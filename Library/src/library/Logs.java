/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Logs {
    private class Event implements java.io.Serializable, Comparable<Event>{

        private boolean workType;
        private boolean complete;
        
        private Date startDate, completeDate;
        private String requestName, action, completeName;
        private int priority;

        private String title, host, where, discription;
        private Date date;

        Event() {
            complete = false;
        }
        Event(Event e){
            workType=e.workType;
            complete=e.complete;
            startDate=e.startDate;
            completeDate=e.completeDate;
            requestName=e.requestName;
            action=e.action;
            completeName=e.completeName;
            priority=e.priority;
            title=e.title;
            host=e.host;
            where=e.where;
            discription=e.discription;
            date=e.date;
        }

        public String returnDataGroup() {
            if (workType) {
                return priority + " " + startDate.toString() + " " + requestName + " " + action + " " + completeName + " " + completeDate.toString();
            } else {
                return date.toString() + " " + title + " " + host + " " + where + " " + discription;
            }
        }

        @Override
        public int compareTo(Event o) {
            if(workType&& !complete){
                if(this.priority>o.priority){
                    return 1;
                }else if(this.priority==o.priority){
                    if(this.startDate.before(o.startDate)){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }else if(workType && complete){
                if(this.completeDate.after(o.completeDate)){
                    return 1;
                }else{
                    return -1;
                }
            }else if(!workType && !complete){
                if(this.date.before(o.date)){
                    return 1;
                }else{
                    return -1;
                }
            }else{//!workType && complete
                if(this.date.after(o.date)){
                    return 1;
                }else{
                    return -1;
                }
            }
        }

    }
    
    boolean eeee,llll;
    
    Logs(){
        try {
            readEvents();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            eeee=false;
        }
        try {
            readLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            llll=false;
        }
        
    }

    //may need fixing
    ArrayList<Event> workLog = new ArrayList<>();//Only store currently active requests
    ArrayList<Event> completedWorkLog = new ArrayList<>();

    ArrayList<Event> eventLog = new ArrayList<>();//only store currently active requests
    ArrayList<Event> completedEventLog = new ArrayList<>();
    
    void addWorkLog(int priority, Date startDate, String requestName, String action) throws IOException {
        try {
            readLogs();
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
        }
        Event w = new Event();
        w.workType = true;
        w.priority = priority;
        w.startDate = startDate;
        w.requestName = requestName;
        w.action = action;
        workLog.add(w);
        writeLogs();
    }
    
    Event searchLogs(String[] x){
        try {
            readLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        for(int i=0;i<workLog.size();i++){
            if(x[0].equals(workLog.get(i).startDate.toString()) && x[1].equals(workLog.get(i).requestName) && x[2].equals(workLog.get(i).action)){
                return workLog.get(i);
            }
        }
        return null;         
    }
    
    

    boolean completedTask(Event e, String completeName, Date completeDate) {
        try {
            readEvents();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if (deleteTask(e)) {
            e.completeDate = completeDate;
            e.completeName = completeName;
            e.complete = true;
            
            return true;
        }
        return false;
    }

    boolean deleteTask(Event e) {
        if (workLog.contains(e)) {
            return workLog.remove(e);
        } else {
            return false;
        }
    }

    void clearLog() {
        try {
            readLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        workLog.clear();
        
        try {
            writeLogs();
        } catch (IOException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void writeLogs() throws IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnWorkLogsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(workLog);
        oos.close();
        fos.close();
    }
    
    private void readLogs() throws IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnWorkLogsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        workLog = (ArrayList<Event>) ois.readObject();
        ois.close();
        fis.close();
    }
    

    
    void addEvent(Date date, String title, String host, String where, String discription) throws IOException {
        Event e = new Event();
        e.workType = false;
        e.date = date;
        e.title = title;
        e.host = host;
        e.where = where;
        e.discription = discription;
        eventLog.add(e);
        writeEvents();
    }
    
    Event searchEvents(String[] x){
        try {
            readEvents();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        for(int i=0;i<eventLog.size();i++){
            if(x[0].equals(eventLog.get(i).date) && x[1].equals(eventLog.get(i).title) && x[2].equals(eventLog.get(i).host) 
                && x[3].equals(eventLog.get(i).where) && x[4].equals(eventLog.get(i).discription)){
                return eventLog.get(i);
            }
        }
        return null;    
    }

    boolean deleteEvent(Event e) {
        if (eventLog.contains(e)) {
            eventLog.remove(e);
            try {
                writeEvents();
                return true;
            } catch (IOException ex) {
                //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    void clearEvents() {
        eventLog.clear();
    }

    void completedEvent(Event e) {
        e.complete = true;
        deleteEvent(e);
    }
    
    private void writeEvents() throws IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnEventsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(eventLog);
        oos.close();
        fos.close();
    }
    
    private void readEvents() throws IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnEventsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        workLog = (ArrayList<Event>) ois.readObject();
        ois.close();
        fis.close();
    }
    
}
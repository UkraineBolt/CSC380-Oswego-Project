/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        @Override
        public boolean equals(Object obj){
            if (obj == this) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            /*if (this.getClass() != obj.getClass()) {
                return false;
            }*/
            Event t = (Event) obj;
            if (t.workType && !t.complete) {
                if(!this.action.equals(t.action) || !this.requestName.equals(t.requestName)){
                    return false;
                }
                if(!this.startDate.equals(t.startDate)){
                    return false;
                }
                if(this.priority!=t.priority){
                    return false;
                }
            }else if (t.workType && t.complete) {
                if(this.priority!=t.priority){
                    return false;
                }
                if(!this.startDate.equals(t.startDate)||!this.completeDate.equals(t.completeDate)){
                    return false;
                }
                if(!this.action.equals(t.action) || !this.requestName.equals(t.requestName) || !this.completeName.equals(t.completeName)){
                    return false;
                }
            }else if(!t.workType){
                if(!this.date.equals(t.date)){
                    return false;
                }
                if(!this.title.equals(t.title) || !this.host.equals(t.host) || !this.where.equals(t.where) || !this.discription.equals(t.discription)){
                    return false;
                }
            }
            
            return true;
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
    
    Event searchLog(int priority, Date start, String name, String action){
        try {
            readLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        Event fake = new Event();
        fake.priority=priority;
        fake.startDate=start;
        fake.requestName=name;
        fake.action=action;
        for(int i=0;i<workLog.size();i++){
            if(workLog.get(i).equals(fake)){
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
    
    private void writeCompletedLogs() throws IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnCompletedLogsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(completedWorkLog);
        oos.close();
        fos.close();
    }
    private void readCompletedLogs() throws IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnCompletedLogsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        completedWorkLog = (ArrayList<Event>) ois.readObject();
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
    
    Event searchEvent(Date d, String title, String host, String where, String dis){
        try {
            readEvents();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        Event fake = new Event();
        fake.date=d;
        fake.title=title;
        fake.host=host;
        fake.discription=dis;
        fake.where=where;
        for(int i=0;i<eventLog.size();i++){
            if(eventLog.get(i).equals(fake)){
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

    void completedEvent(Event e) {
        e.complete = true;
        deleteEvent(e);
        
        completedEventLog.add(e);
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
    
    private void writeCompletedEvents() throws IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnCompletedEventsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(completedEventLog);
        oos.close();
        fos.close();
    }
    private void readCompletedEvents() throws IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnCompletedEventsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        completedEventLog = (ArrayList<Event>) ois.readObject();
        ois.close();
        fis.close();
    }
    
}
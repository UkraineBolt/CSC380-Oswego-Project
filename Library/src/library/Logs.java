/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author alex
 */
public class Logs {

    private class Event implements java.io.Serializable{

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

        public String returnDataGroup() {
            if (workType) {
                return priority + " " + startDate.toString() + " " + requestName + " " + action + " " + completeName + " " + completeDate.toString();
            } else {
                return date.toString() + " " + title + " " + host + " " + where + " " + discription;
            }
        }

    }
    
    Logs(){
        
    }

    //may need fixing
    PriorityQueue<Event> workLog = new PriorityQueue<>(50, (Event o1, Event o2) -> {
        if (o1.priority > o2.priority) {
            return 1;
        } else if (o1.priority == o2.priority) {
            if (o1.startDate.after(o2.startDate)) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    });//Only store currently active requests

    PriorityQueue<Event> eventLog = new PriorityQueue<>(50, (Event o1, Event o2) -> {
        if (o1.date.after(o2.date)) {
            return 1;
        } else {
            return -1;
        }
    });//only store currently active requests

    void addWorkLog(int priority, Date startDate, String requestName, String action) {
        Event w = new Event();
        w.workType = true;
        w.priority = priority;
        w.startDate = startDate;
        w.requestName = requestName;
        w.action = action;
        workLog.add(w);
    }

    void completedTask(Event e, String completeName, Date completeDate) {
        if (deleteTask(e)) {

        }
        e.completeDate = completeDate;
        e.completeName = completeName;
        e.complete = true;
    }

    boolean deleteTask(Event e) {
        if (workLog.contains(e)) {
            return workLog.remove(e);
        } else {
            return false;
        }
    }

    void clearLog() {
        workLog.clear();
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
        workLog = (PriorityQueue<Event>) ois.readObject();
        ois.close();
        fis.close();
    }
    
    private void dumpLogs(Event e) throws IOException{
        WR paths = new WR();
        File folder = new File(paths.returnLogFolderPath());
        File[] files = folder.listFiles();
        int i=0;
        int count=0;
        File f = null;
        while(i<files.length){
            if(files[i].getName().contains("WL")){
               f = files[i];
               count++;
            }
            i++;
        }
        if(f==null){
            f = new File(paths.returnLogFolderPath()+"\\WL"+count);
        }else{
            int p = 0;
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                p++;
            }
            if(p>4999){
                f = new File(paths.returnLogFolderPath()+"\\WL"+count);
                f.createNewFile();
            }
        }
        
        PrintWriter pw = new PrintWriter(f);
        pw.println(e.returnDataGroup());
        
    }
    private void deleteDumpLogs(){
        WR paths = new WR();
        File folder = new File(paths.returnLogFolderPath());
        File[] files = folder.listFiles();
        int i=0;
        while(i<files.length){
            if(files[i].getName().contains("WL")){
                files[i].delete();
            }
            i++;
        }
    }
    

    void addEvent(Date date, String title, String host, String where, String discription) {
        Event e = new Event();
        e.workType = false;
        e.date = date;
        e.title = title;
        e.host = host;
        e.where = where;
        e.discription = discription;
        eventLog.add(e);
    }

    void editEvent(Event e, String x) {
        if (x.toLowerCase().equals("cancelled")) {
            completedEvent(e);
        } else {
            e.discription = x;
        }
    }

    boolean deleteEvent(Event e) {
        if (eventLog.contains(e)) {
            return eventLog.remove(e);
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
        workLog = (PriorityQueue<Event>) ois.readObject();
        ois.close();
        fis.close();
    }
    
    private void dumpEvents(Event e) throws IOException{
        WR paths = new WR();
        File folder = new File(paths.returnLogFolderPath());
        File[] files = folder.listFiles();
        int i=0;
        int count=0;
        File f = null;
        while(i<files.length){
            if(files[i].getName().contains("E")){
               f = files[i];
               count++;
            }
        }
        if(f==null){
            f = new File(paths.returnLogFolderPath()+"\\E"+count);
        }else{
            int p = 0;
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                p++;
            }
            if(p>4999){
                f = new File(paths.returnLogFolderPath()+"\\E"+count);
                f.createNewFile();
            }
        }
        
        PrintWriter pw = new PrintWriter(f);
        pw.print(e.returnDataGroup());
    }
    
    private void deleteDumpEvents(){
        WR paths = new WR();
        File folder = new File(paths.returnLogFolderPath());
        File[] files = folder.listFiles();
        int i=0;
        while(i<files.length){
            if(files[i].getName().contains("E")){
                files[i].delete();
            }
            i++;
        }
    }

}

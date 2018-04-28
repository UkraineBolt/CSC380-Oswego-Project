/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Logs implements java.io.Serializable{
    public class Event implements java.io.Serializable, Comparable<Event>{

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

        @Override
        public String toString() {
            SimpleDateFormat at = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            if (workType && complete) {
                return priority + ":::" + at.format(startDate) + ":::" + requestName + ":::" + action + ":::" + completeName + ":::" + at.format(completeDate);
            } else if(workType && !complete){
                return priority + ":::" + at.format(startDate) + ":::" + requestName + ":::" + action;
            }else {
                return at.format(date) + ":::" + title + ":::" + host + ":::" + where + ":::" + discription;
            }
        }

        @Override
        public int compareTo(Event o) {
            if(workType&& !complete){
                if(this.priority>o.priority){
                    return 1;
                }else if(this.priority==o.priority){
                    if(this.startDate.after(o.startDate)){
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
    
    Logs(){
        workLog = new ArrayList<>();
        completedWorkLog = new ArrayList<>();
        eventLog = new ArrayList<>();
        completedEventLog = new ArrayList<>();
    }

    //may need fixing
    ArrayList<Event> workLog;//Only store currently active requests
    ArrayList<Event> completedWorkLog;

    ArrayList<Event> eventLog;//only store currently active requests
    ArrayList<Event> completedEventLog;
    
    boolean addWorkLog(int priority, Date startDate, String requestName, String action) {
        Event w = new Event();
        w.workType = true;
        w.priority = priority;
        w.startDate = startDate;
        w.requestName = requestName;
        w.action = action;
        return workLog.add(w);
    }
    
    Event searchLog(int priority, Date start, String name, String action){
        Event fake = new Event();
        fake.priority=priority;
        fake.startDate=start;
        fake.requestName=name;
        fake.action=action;
        fake.workType=true;
        for(int i=0;i<workLog.size();i++){
            if(workLog.get(i).equals(fake)){
                return workLog.get(i);
            }
        }
        return null;         
    }
    
    boolean completeLog(Event e){
        if(e==null){
            return false;
        }
        workLog.remove(e);
        e.complete=true;
        completedWorkLog.add(e);
        return true;
    }
   
    

    
    boolean addEvent(Date date, String title, String host, String where, String discription){
        Event e = new Event();
        e.workType = false;
        e.date = date;
        e.title = title;
        e.host = host;
        e.where = where;
        e.discription = discription;
        return eventLog.add(e);
    }
    
    Event searchEvent(Date d, String title, String host, String where, String dis){
        Event fake = new Event();
        fake.date=d;
        fake.title=title;
        fake.host=host;
        fake.discription=dis;
        fake.where=where;
        fake.workType=false;
        for(int i=0;i<eventLog.size();i++){
            if(eventLog.get(i).equals(fake)){
                return eventLog.get(i);
            }
        }
        
        return null;
    }

    boolean deleteEvent(Event e) {
        if(e!=null){
            eventLog.remove(e);
            return true;
        }
        return false;
    }
    
    boolean checkForCompletedEvents(){
        Date d = new Date();  
        for(int i=0;i<eventLog.size();i++){
            if(eventLog.get(i).date.before(d)){
                completedEventLog.add(eventLog.remove(i));
            }
        }
        return true;
    }
}
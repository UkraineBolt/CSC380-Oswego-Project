/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 *
 * @author alex
 */
class Logs {

    private class Event /*implements Comparable<Event>*/{ 

        private boolean workType;
        private Date startDate, completeDate;
        private String requestName, action, completeName;
        private int priority;

        private String title, host, where, discription;
        private Date date;
        
        public String returnDataGroup() {
            if (workType) {
                return priority + startDate.toString() + requestName + action + completeName + completeDate.toString();
            } else {
                return date.toString() + title + host + where + discription;
            }
        }

        /*@Override
        public int compareTo(Event o) {
            if(o.priority>this.priority){
                return 1;
            } else{
                return -1;
            }
        }*/

    }
    
    
    PriorityQueue<Event> workLog = new PriorityQueue<>(50, (Event o1, Event o2) -> {
        if(o1.priority>o2.priority){
            return 1;
        }else{
            return -1;
        }
    });
    
    PriorityQueue<Event> eventLog = new PriorityQueue<>(50, (Event o1, Event o2) -> {
        if(o1.date.compareTo(o2.date)>0){
            return 1;
        }else{
            return -1;
        }
    });

    void addWorkLog(int priority,Date startDate,String requestName,String action,String completeName,Date completeDate) {
        Event w = new Event();
        w.workType=true;
        w.priority=priority;
        w.startDate=startDate;
        w.requestName=requestName;
        w.action=action;
        w.completeName=completeName;
        w.completeDate=completeDate;
        workLog.add(w);
    }

    void addEvent(Date date, String title, String host, String where, String discription) {
        Event e = new Event();
        e.workType=false;
        e.date=date;
        e.title=title;
        e.host=host;
        e.where=where;
        e.discription=discription;
    }
    
    
    
    
}

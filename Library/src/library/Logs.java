/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Date;
import java.util.PriorityQueue;

/**
 *
 * @author alex
 */
public class Logs {

    private class Event {

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
                return priority + startDate.toString() + requestName + action + completeName + completeDate.toString();
            } else {
                return date.toString() + title + host + where + discription;
            }
        }

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
        e.completeDate = completeDate;
        e.completeName = completeName;
        e.complete = true;

        if (deleteTask(e)) {
            
        }

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
    }

}

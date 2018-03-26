/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class LogsTest {
    ArrayList<String> events;
    public LogsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Before
    public void setUp() {
        events = new ArrayList();
    }
    
    @After
    public void tearDown() {
        events.clear();
    }

    @Test
    public void testAddEvent() {
        setUp();
        events.add("Event 1");
        events.add("Event 2");
        events.add("Event 3");
    }
    
    @Test
    public void testPrintEvent(){
        testAddEvent();
        for(int i=0;i<events.size();i++){
            System.out.println(events.get(i));
        }
        tearDown();
    }
    @Test
    public void testDeleteEvent(){
       testAddEvent();
       for(int i=0;i<events.size();i++){
            events.remove(i);
       }
    }
    @Test
    public void testReplaceEvent(){
        testAddEvent();
        for(int i=0;i<events.size();i++){
            events.remove(i);
        }
        for(int i=0;i<3;i++){
            events.add("new event 1");
            events.add("new event 2");
            events.add("new event 3");
        }
    }
    
}

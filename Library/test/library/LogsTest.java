/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Date;
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
    
    public LogsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addWorkLog method, of class Logs.
     */
    @org.junit.Test
    public void testAddWorkLog() {
        System.out.println("addWorkLog");
        int priority = 0;
        Date startDate = null;
        String requestName = "";
        String action = "";
        Logs instance = new Logs();
        boolean expResult = false;
        boolean result = instance.addWorkLog(priority, startDate, requestName, action);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchLog method, of class Logs.
     */
    @org.junit.Test
    public void testSearchLog() {
        System.out.println("searchLog");
        int priority = 0;
        Date start = null;
        String name = "";
        String action = "";
        Logs instance = new Logs();
        Logs.Event expResult = null;
        Logs.Event result = instance.searchLog(priority, start, name, action);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completeLog method, of class Logs.
     */
    @org.junit.Test
    public void testCompleteLog() {
        System.out.println("completeLog");
        Logs.Event e = null;
        String name = "";
        Date d = null;
        Logs instance = new Logs();
        boolean expResult = false;
        boolean result = instance.completeLog(e, name, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEvent method, of class Logs.
     */
    @org.junit.Test
    public void testAddEvent() {
        System.out.println("addEvent");
        Date date = null;
        String title = "";
        String host = "";
        String where = "";
        String discription = "";
        Logs instance = new Logs();
        boolean expResult = false;
        boolean result = instance.addEvent(date, title, host, where, discription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchEvent method, of class Logs.
     */
    @org.junit.Test
    public void testSearchEvent() {
        System.out.println("searchEvent");
        Date d = null;
        String title = "";
        String host = "";
        String where = "";
        String dis = "";
        Logs instance = new Logs();
        Logs.Event expResult = null;
        Logs.Event result = instance.searchEvent(d, title, host, where, dis);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEvent method, of class Logs.
     */
    @org.junit.Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        Logs.Event e = null;
        Logs instance = new Logs();
        boolean expResult = false;
        boolean result = instance.deleteEvent(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkForCompletedEvents method, of class Logs.
     */
    @org.junit.Test
    public void testCheckForCompletedEvents() {
        System.out.println("checkForCompletedEvents");
        Logs instance = new Logs();
        boolean expResult = false;
        boolean result = instance.checkForCompletedEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

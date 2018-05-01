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
    Logs x;
    public LogsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        x = new Logs();
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
        Date startDate = new Date();
        String requestName = "alex";
        String action = "test";
        boolean expResult = true;
        boolean result = x.addWorkLog(priority, startDate, requestName, action);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchLog method, of class Logs.
     */
    @org.junit.Test
    public void testSearchLog() {
        System.out.println("searchLog");
        setUp();
        Date d = new Date();
        x.addWorkLog(0, d, "alex", "testing");
        Logs.Event r = x.searchLog(0, d, "alex", "testing");
        boolean result = r!=null;
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of completeLog method, of class Logs.
     */
    @org.junit.Test
    public void testCompleteLog() {
        System.out.println("completeLog");
        setUp();
        Date d = new Date();
        x.addWorkLog(0, d, "alex", "testing");
        boolean expResult = true;
        boolean result = x.completeLog(x.searchLog(0, d, "alex", "testing"), "alex", d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addEvent method, of class Logs.
     */
    @org.junit.Test
    public void testAddEvent() {
        System.out.println("addEvent");
        setUp();
        Date d = new Date();
        boolean expResult = true;
        boolean result = x.addEvent(d, "x", "x", "x", "x");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchEvent method, of class Logs.
     */
    @org.junit.Test
    public void testSearchEvent() {
        System.out.println("searchEvent");
        setUp();
        Date d = new Date();
        x.addEvent(d, "x", "x", "x", "x");
        boolean result = x.searchEvent(d, "x", "x", "x", "x")!=null;
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEvent method, of class Logs.
     */
    @org.junit.Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        setUp();
        Date d = new Date();
        x.addEvent(d, "x", "x", "x", "x");
        boolean expResult = true;
        boolean result = x.deleteEvent(x.searchEvent(d, "x", "x", "x", "x"));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkForCompletedEvents method, of class Logs.
     */
    @org.junit.Test
    public void testCheckForCompletedEvents() {
        System.out.println("checkForCompletedEvents");
        boolean expResult = true;
        boolean result = x.checkForCompletedEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

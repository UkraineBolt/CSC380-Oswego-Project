/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class AdminPageTest {
    AdminPage x;
    public AdminPageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        x = new AdminPage();
        x.setConstants(10, 10, 10, 10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setConstants method, of class AdminPage.
     */
    @org.junit.Test
    public void testSetConstants() {
        System.out.println("setConstants");
        int l = 1;
        double f = 1.0;
        int c = 1;
        double d = 1.0;
        x.setConstants(l, f, c, d);
        boolean z;
        z = x.getCheckOutSize()==1&&x.getDMGFees()==1.0&&x.getFee()==1&&x.getKeepTime()==1;
        assertEquals(true,z);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getKeepTime method, of class AdminPage.
     */
    @org.junit.Test
    public void testGetKeepTime() {
        System.out.println("getKeepTime");
        setUp();
        int expResult = 10;
        int result = x.getKeepTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFee method, of class AdminPage.
     */
    @org.junit.Test
    public void testGetFee() {
        System.out.println("getFee");
        setUp();
        double expResult = 10.0;
        double result = x.getFee();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCheckOutSize method, of class AdminPage.
     */
    @org.junit.Test
    public void testGetCheckOutSize() {
        System.out.println("getCheckOutSize");
        setUp();
        int expResult = 10;
        int result = x.getCheckOutSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDMGFees method, of class AdminPage.
     */
    @org.junit.Test
    public void testGetDMGFees() {
        System.out.println("getDMGFees");
        setUp();
        double expResult = 10.0;
        double result = x.getDMGFees();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

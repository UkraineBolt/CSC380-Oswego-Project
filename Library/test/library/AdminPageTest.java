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
    
    public AdminPageTest() {
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
     * Test of getKeepTime method, of class AdminPage.
     */
    @Test
    public void testGetKeepTime() {
        System.out.println("getKeepTime");
        AdminPage instance = new AdminPage();
        long expResult = 0L;
        long result = instance.getKeepTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFee method, of class AdminPage.
     */
    @Test
    public void testGetFee() {
        System.out.println("getFee");
        AdminPage instance = new AdminPage();
        double expResult = 0.0;
        double result = instance.getFee();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCheckOutSize method, of class AdminPage.
     */
    @Test
    public void testGetCheckOutSize() {
        System.out.println("getCheckOutSize");
        AdminPage instance = new AdminPage();
        int expResult = 0;
        int result = instance.getCheckOutSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDMGFees method, of class AdminPage.
     */
    @Test
    public void testGetDMGFees() {
        System.out.println("getDMGFees");
        AdminPage instance = new AdminPage();
        double expResult = 0.0;
        double result = instance.getDMGFees();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

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
public class HandlerTest {
    
    public HandlerTest() {
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
     * Test of signIn method, of class Handler.
     */
    @Test
    public void testSignIn() {
        System.out.println("signIn");
        String user = "";
        String pass = "";
        Handler instance = new Handler();
        boolean expResult = false;
        boolean result = instance.signIn(user, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Handler.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        String u = "";
        String p = "";
        String fn = "";
        String ln = "";
        String add = "";
        String c = "";
        String em = "";
        String ph = "";
        String zip = "";
        String st = "";
        Handler instance = new Handler();
        boolean expResult = true;
        boolean result = instance.create(u, p, fn, ln, add, c, em, ph, zip, st);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

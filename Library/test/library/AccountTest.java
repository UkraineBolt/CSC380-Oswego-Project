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
public class AccountTest {
    
    public AccountTest() {
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
     * Test of compareTo method, of class Account.
     */
    @org.junit.Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Account o = null;
        Account instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getname method, of class Account.
     */
    @org.junit.Test
    public void testGetname() {
        System.out.println("getname");
        Account instance = null;
        String expResult = "";
        String result = instance.getname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkoutIsEmpty method, of class Account.
     */
    @org.junit.Test
    public void testCheckoutIsEmpty() {
        System.out.println("checkoutIsEmpty");
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.checkoutIsEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gettype method, of class Account.
     */
    @org.junit.Test
    public void testGettype() {
        System.out.println("gettype");
        Account instance = null;
        int expResult = 0;
        int result = instance.gettype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFee method, of class Account.
     */
    @org.junit.Test
    public void testAddFee() {
        System.out.println("addFee");
        double dmg = 0.0;
        boolean d = false;
        String crn = "";
        double f = 0.0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.addFee(dmg, d, crn, f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateKeepLimit method, of class Account.
     */
    @org.junit.Test
    public void testUpdateKeepLimit() {
        System.out.println("updateKeepLimit");
        int x = 0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.updateKeepLimit(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibNum method, of class Account.
     */
    @org.junit.Test
    public void testGetLibNum() {
        System.out.println("getLibNum");
        Account instance = null;
        int expResult = 0;
        int result = instance.getLibNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClearFee method, of class Account.
     */
    @org.junit.Test
    public void testClearFee() {
        System.out.println("ClearFee");
        Account instance = null;
        instance.ClearFee();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareEmail method, of class Account.
     */
    @org.junit.Test
    public void testCompareEmail() {
        System.out.println("compareEmail");
        String x = "";
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.compareEmail(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBill method, of class Account.
     */
    @org.junit.Test
    public void testGetBill() {
        System.out.println("getBill");
        Account instance = null;
        double expResult = 0.0;
        double result = instance.getBill();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckOutBook method, of class Account.
     */
    @org.junit.Test
    public void testCheckOutBook() {
        System.out.println("CheckOutBook");
        Stock.Book b = null;
        int days = 0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.CheckOutBook(b, days);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnFee method, of class Account.
     */
    @org.junit.Test
    public void testReturnFee() {
        System.out.println("returnFee");
        boolean paid = false;
        Account instance = null;
        double expResult = 0.0;
        double result = instance.returnFee(paid);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payFee method, of class Account.
     */
    @org.junit.Test
    public void testPayFee() {
        System.out.println("payFee");
        Account instance = null;
        instance.payFee();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ReturnBook method, of class Account.
     */
    @org.junit.Test
    public void testReturnBook() {
        System.out.println("ReturnBook");
        Stock.Book b = null;
        boolean fees = false;
        double dmg = 0.0;
        double checkoutfee = 0.0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.ReturnBook(b, fees, dmg, checkoutfee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Account.
     */
    @org.junit.Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Account instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeType method, of class Account.
     */
    @org.junit.Test
    public void testChangeType() {
        System.out.println("changeType");
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.changeType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Account.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Account instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

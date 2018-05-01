/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import library.Stock.Book;
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
    Account x;
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        x = new Account(AccountType.Employer,"firstname","lastname","address","city","email","phonenum","zip","state","username",0,0);
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
        Account instance = new Account(null,"firstname","lastname","address","city","email","phonenum","zip","state","username",0,0);
        int expResult = 0;
        int result = instance.compareTo(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getname method, of class Account.
     */
    @org.junit.Test
    public void testGetname() {
        System.out.println("getname");
        String expResult = "firstname lastname";
        String result = x.getname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkoutIsEmpty method, of class Account.
     */
    @org.junit.Test
    public void testCheckoutIsEmpty() {
        System.out.println("checkoutIsEmpty");
        boolean expResult = true;
        boolean result = x.checkoutIsEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of gettype method, of class Account.
     */
    @org.junit.Test
    public void testGettype() {
        System.out.println("gettype");
        int expResult = 0;
        int result = x.gettype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addFee method, of class Account.
     */
    @org.junit.Test
    public void testAddFee() {
        System.out.println("addFee");
        double dmg = 0.0;
        boolean d = false;
        String crn = "123456789";
        double f = 0.0;
        boolean expResult = false;
        boolean result = x.addFee(dmg, d, crn, f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateKeepLimit method, of class Account.
     */
    @org.junit.Test
    public void testUpdateKeepLimit() {
        System.out.println("updateKeepLimit");
        boolean expResult = true;
        boolean result = x.updateKeepLimit(10);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLibNum method, of class Account.
     */
    @org.junit.Test
    public void testGetLibNum() {
        System.out.println("getLibNum");
        int expResult = 0;
        int result = x.getLibNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of compareEmail method, of class Account.
     */
    @org.junit.Test
    public void testCompareEmail() {
        System.out.println("compareEmail");
        boolean expResult = true;
        boolean result = x.compareEmail("email");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckOutBook method, of class Account.
     */
    @org.junit.Test
    public void testCheckOutBook() {
        System.out.println("CheckOutBook");
        Stock.Book b = null;
        int days = 7;
        boolean expResult = false;
        boolean result = x.CheckOutBook(b, days);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnFee method, of class Account.
     */
    @org.junit.Test
    public void testReturnFee() {
        System.out.println("returnFee");
        boolean paid = false;
        double expResult = 0.0;
        double result = x.returnFee(paid);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        boolean expResult = false;
        boolean result = x.ReturnBook(b, fees, dmg, checkoutfee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Account.
     */
    @org.junit.Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "username";
        String result = x.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of changeType method, of class Account.
     */
    @org.junit.Test
    public void testChangeType() {
        System.out.println("changeType");
        boolean expResult = true;
        boolean result = x.changeType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Account.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "firstname:::lastname:::address:::city:::state:::zip:::phonenum:::email:::Employer:::username:::0";
        String result = x.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

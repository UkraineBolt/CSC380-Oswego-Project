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
public class AccountsTest {
    
    public AccountsTest() {
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
     * Test of checkForNull method, of class Accounts.
     */
    @org.junit.Test
    public void testCheckForNull() {
        System.out.println("checkForNull");
        Accounts instance = new Accounts();
        boolean expResult = false;
        boolean result = instance.checkForNull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callByLibNum method, of class Accounts.
     */
    @org.junit.Test
    public void testCallByLibNum() {
        System.out.println("callByLibNum");
        int libnum = 0;
        Accounts instance = new Accounts();
        Account expResult = null;
        Account result = instance.callByLibNum(libnum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNumber method, of class Accounts.
     */
    @org.junit.Test
    public void testCheckNumber() {
        System.out.println("checkNumber");
        int x = 0;
        Accounts instance = new Accounts();
        boolean expResult = false;
        boolean result = instance.checkNumber(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfAccounts method, of class Accounts.
     */
    @org.junit.Test
    public void testGetListOfAccounts() {
        System.out.println("getListOfAccounts");
        Accounts instance = new Accounts();
        ArrayList<Account> expResult = null;
        ArrayList<Account> result = instance.getListOfAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realterCheckoutSize method, of class Accounts.
     */
    @org.junit.Test
    public void testRealterCheckoutSize() {
        System.out.println("realterCheckoutSize");
        int checkoutSize = 0;
        Accounts instance = new Accounts();
        boolean expResult = false;
        boolean result = instance.realterCheckoutSize(checkoutSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeAccount method, of class Accounts.
     */
    @org.junit.Test
    public void testMakeAccount() {
        System.out.println("makeAccount");
        String uname = "";
        String pass = "";
        Account a = null;
        Accounts instance = new Accounts();
        boolean expResult = false;
        boolean result = instance.makeAccount(uname, pass, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeStatus method, of class Accounts.
     */
    @org.junit.Test
    public void testChangeStatus() {
        System.out.println("changeStatus");
        String u = "";
        Accounts instance = new Accounts();
        boolean expResult = false;
        boolean result = instance.changeStatus(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emailToUserID method, of class Accounts.
     */
    @org.junit.Test
    public void testEmailToUserID() {
        System.out.println("emailToUserID");
        String x = "";
        Accounts instance = new Accounts();
        String expResult = "";
        String result = instance.emailToUserID(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class Accounts.
     */
    @org.junit.Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String username = "";
        String newpass = "";
        Accounts instance = new Accounts();
        boolean expResult = false;
        boolean result = instance.changePassword(username, newpass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callAccount method, of class Accounts.
     */
    @org.junit.Test
    public void testCallAccount() {
        System.out.println("callAccount");
        String name = "";
        String pass = "";
        Accounts instance = new Accounts();
        Account expResult = null;
        Account result = instance.callAccount(name, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAccount method, of class Accounts.
     */
    @org.junit.Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        String name = "";
        String pass = "";
        Accounts instance = new Accounts();
        boolean expResult = false;
        boolean result = instance.deleteAccount(name, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

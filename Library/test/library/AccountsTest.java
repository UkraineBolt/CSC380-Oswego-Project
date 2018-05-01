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
    Accounts x;
    Account a;
    public AccountsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        x = new Accounts();
        a = new Account(AccountType.Employer,"firstname","lastname","address","city","email","phonenum","zip","state","username",0,0);
        
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
        boolean expResult = true;
        boolean result = x.checkForNull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of callByLibNum method, of class Accounts.
     */
    @org.junit.Test
    public void testCallByLibNum() {
        System.out.println("callByLibNum");
        int libnum = 0;
        Account expResult = null;
        Account result = x.callByLibNum(libnum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkNumber method, of class Accounts.
     */
    @org.junit.Test
    public void testCheckNumber() {
        System.out.println("checkNumber");
        boolean expResult = true;
        boolean result = x.checkNumber(0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfAccounts method, of class Accounts.
     */
    @org.junit.Test
    public void testGetListOfAccounts() {
        System.out.println("getListOfAccounts");
        int expResult = 0;
        ArrayList<Account> result = x.getListOfAccounts();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of realterCheckoutSize method, of class Accounts.
     */
    @org.junit.Test
    public void testRealterCheckoutSize() {
        System.out.println("realterCheckoutSize");
        int checkoutSize = 0;
        boolean expResult = true;
        boolean result = x.realterCheckoutSize(checkoutSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of makeAccount method, of class Accounts.
     */
    @org.junit.Test
    public void testMakeAccount() {
        System.out.println("makeAccount");
        String uname = "";
        String pass = "";
        Account a = new Account(AccountType.Employer,"firstname","lastname","address","city","email","phonenum","zip","state","username",0,0);
        boolean expResult = true;
        boolean result = x.makeAccount(uname, pass, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of changeStatus method, of class Accounts.
     */
    @org.junit.Test
    public void testChangeStatus() {
        setUp();
        x.makeAccount("1234", "1234", a);
        System.out.println("changeStatus");
        boolean expResult = true;
        boolean result = x.changeStatus("1234");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of emailToUserID method, of class Accounts.
     */
    @org.junit.Test
    public void testEmailToUserID() {
        System.out.println("emailToUserID");
        setUp();
        x.makeAccount("1234", "1234", a);
        String expResult = "username";
        String result = x.emailToUserID("email");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class Accounts.
     */
    @org.junit.Test
    public void testChangePassword() {
        System.out.println("changePassword");
        setUp();
        x.makeAccount("1234", "12345", a);
        String username = "1234";
        String newpass = "1234";
        boolean expResult = true;
        boolean result = x.changePassword(username, newpass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of callAccount method, of class Accounts.
     */
    @org.junit.Test
    public void testCallAccount() {
        System.out.println("callAccount");
        setUp();
        x.makeAccount("1234", "1234", a);
        String name = "1234";
        String pass = "1234";
        //Account expResult = null;
        Account result = x.callAccount(name, pass);
        boolean r= result!=null;
        assertEquals(true, r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAccount method, of class Accounts.
     */
    @org.junit.Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        setUp();
        x.makeAccount("1234", "1234", a);
        String name = "1234";
        String pass = "1234";
        boolean expResult = true;
        boolean result = x.deleteAccount(name, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

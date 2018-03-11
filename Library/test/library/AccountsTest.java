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
public class AccountsTest {//this should work
    Account dummy;
    String uname;
    String pass;
    Accounts instance;
    public AccountsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        dummy=new Account(AccountType.Client,"","","","","","","","");
        uname="abcde";
        pass="12345";
        instance = new Accounts();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeAccount method, of class Accounts.
     */
    @Test
    public void testMakeAccount() {
        setUp();
        System.out.println("makeAccount");
        Account a = dummy;
        boolean expResult = true;
        boolean result = instance.makeAccount(uname, pass, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of callAccount method, of class Accounts.
     */
    @Test
    public void testCallAccount() {
        setUp();
        instance.makeAccount(uname, pass, dummy);
        System.out.println("callAccount");
        Account expResult = dummy;
        Account result = instance.callAccount(uname, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAccount method, of class Accounts.
     */
    @Test
    public void testDeleteAccount() {
        setUp();
        instance.makeAccount(uname, pass, dummy);
        System.out.println("deleteAccount");
        boolean expResult = true;
        boolean result = instance.deleteAccount(uname, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

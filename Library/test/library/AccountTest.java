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
    Account dummy;
    AdminPage ap;
    public AccountTest() {
        dummy = new Account(AccountType.Client,"","","","","","","","","");
        ap = new AdminPage();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        dummy = new Account(AccountType.Client,"","","","","","","","","");
        ap = new AdminPage();
        
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of AddFee method, of class Account.
     */
    @Test
    public void testAddFee() {
        setUp();
        System.out.println("AddFee");
        double dmg = 5.90;
        int days = 0;
        dummy.AddFee(dmg, days);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ClearFee method, of class Account.
     */
    @Test
    public void testClearFee() {
        setUp();
        System.out.println("ClearFee");
        dummy.ClearFee();
        double temp = dummy.getBill();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


}

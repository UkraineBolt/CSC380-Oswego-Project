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
public class StockTest {
    
    public StockTest() {
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
     * Test of callCondition method, of class Stock.
     */
    @org.junit.Test
    public void testCallCondition() {
        System.out.println("callCondition");
        String x = "";
        Stock instance = new Stock();
        Condition expResult = null;
        Condition result = instance.callCondition(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callAll method, of class Stock.
     */
    @org.junit.Test
    public void testCallAll() {
        System.out.println("callAll");
        Stock instance = new Stock();
        ArrayList<Stock.Book> expResult = null;
        ArrayList<Stock.Book> result = instance.callAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBook method, of class Stock.
     */
    @org.junit.Test
    public void testSearchBook() {
        System.out.println("searchBook");
        String title = "";
        String author = "";
        int year = 0;
        String crn = "";
        Stock instance = new Stock();
        Stock.Book expResult = null;
        Stock.Book result = instance.searchBook(title, author, year, crn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByCRN method, of class Stock.
     */
    @org.junit.Test
    public void testSearchByCRN() {
        System.out.println("searchByCRN");
        String crn = "";
        Stock instance = new Stock();
        Stock.Book expResult = null;
        Stock.Book result = instance.searchByCRN(crn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limitedSearch method, of class Stock.
     */
    @org.junit.Test
    public void testLimitedSearch() {
        System.out.println("limitedSearch");
        String title = "";
        String author = "";
        int year = 0;
        String crn = "";
        Stock instance = new Stock();
        ArrayList<Stock.Book> expResult = null;
        ArrayList<Stock.Book> result = instance.limitedSearch(title, author, year, crn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareBooksWithLimitedInfo method, of class Stock.
     */
    @org.junit.Test
    public void testCompareBooksWithLimitedInfo() {
        System.out.println("compareBooksWithLimitedInfo");
        Stock.Book a = null;
        Stock.Book b = null;
        Stock instance = new Stock();
        boolean expResult = false;
        boolean result = instance.compareBooksWithLimitedInfo(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBook method, of class Stock.
     */
    @org.junit.Test
    public void testAddBook() {
        System.out.println("addBook");
        String t = "";
        String a = "";
        int year = 0;
        String crn = "";
        Condition c = null;
        ArrayList<String> genres = null;
        Stock instance = new Stock();
        boolean expResult = false;
        boolean result = instance.addBook(t, a, year, crn, c, genres);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeBook method, of class Stock.
     */
    @org.junit.Test
    public void testRemoveBook() {
        System.out.println("removeBook");
        Stock.Book b = null;
        Stock instance = new Stock();
        instance.removeBook(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

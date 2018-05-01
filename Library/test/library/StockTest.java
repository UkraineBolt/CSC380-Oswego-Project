/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
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
public class StockTest {
    Stock x;
    public StockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        x = new Stock();
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
        Condition expResult = Condition.New;
        Condition result = x.callCondition("new");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of callAll method, of class Stock.
     */
    @org.junit.Test
    public void testCallAll() {
        System.out.println("callAll");
        ArrayList<Stock.Book> r = x.callAll();
        boolean result = r.isEmpty();
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchBook method, of class Stock.
     */
    @org.junit.Test
    public void testSearchBook() {
        System.out.println("searchBook");
        setUp();
        ArrayList<String> g = new ArrayList<>();
        g.add("bark");
        x.addBook("a", "a", 0, "a", Condition.New, g);
        Stock.Book r = x.searchBook("a", "a", 0, "a");
        boolean result = r!=null;
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchByCRN method, of class Stock.
     */
    @org.junit.Test
    public void testSearchByCRN() {
        System.out.println("searchByCRN");
         setUp();
        ArrayList<String> g = new ArrayList<>();
        g.add("bark");
        x.addBook("a", "a", 0, "a", Condition.New, g);
        Stock.Book r = x.searchByCRN("a");
        boolean result = r!=null;
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of limitedSearch method, of class Stock.
     */
    @org.junit.Test
    public void testLimitedSearch() {
        System.out.println("limitedSearch");
         setUp();
        ArrayList<String> g = new ArrayList<>();
        g.add("bark");
        x.addBook("a", "a", 0, "a", Condition.New, g);
        ArrayList<Stock.Book> r = x.limitedSearch("a", "a", 0, "a");
        boolean result = !r.isEmpty();
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compareBooksWithLimitedInfo method, of class Stock.
     */
    @org.junit.Test
    public void testCompareBooksWithLimitedInfo() {
        System.out.println("compareBooksWithLimitedInfo");
        Book a = null;
        Book b = null;
        boolean result = x.compareBooksWithLimitedInfo(a, b);
        assertEquals(false, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addBook method, of class Stock.
     */
    @org.junit.Test
    public void testAddBook() {
        System.out.println("addBook");
         setUp();
        ArrayList<String> g = new ArrayList<>();
        g.add("bark");
        boolean expResult = true;
        boolean result = x.addBook("a", "a", 0, "a", Condition.New, g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeBook method, of class Stock.
     */
    @org.junit.Test
    public void testRemoveBook() {
        System.out.println("removeBook");
        setUp();
        ArrayList<String> g = new ArrayList<>();
        g.add("bark");
        x.addBook("a", "a", 0, "a", Condition.New, g);
        x.removeBook(x.searchByCRN("a"));
        boolean result = x.books.isEmpty();
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

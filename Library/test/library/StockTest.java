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
     * Test of addBook method, of class Stock.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        String t = "";
        String a = "";
        int year = 0;
        int crn = 0;
        Condition c = null;
        ArrayList<Genres> genres = null;
        double v = 0.0;
        Stock instance = new Stock();
        instance.addBook(t, a, year, crn, c, genres, v);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeBook method, of class Stock.
     */
    @Test
    public void testRemoveBook() {
        System.out.println("removeBook");
        Stock.Book b = null;
        Stock instance = new Stock();
        instance.removeBook(b);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

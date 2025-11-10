/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSaleTest {
    
    public ProductSaleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of TotalSales method, of class ProductSale.
     */
    @Test
    public void testTotalSales() {
        System.out.println("TotalSales");
        int[][] productSales = null;
        ProductSale instance = new ProductSaleImpl();
        int expResult = 0;
        int result = instance.TotalSales(productSales);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AverageSales method, of class ProductSale.
     */
    @Test
    public void testAverageSales() {
        System.out.println("AverageSales");
        int[][] productSales = null;
        ProductSale instance = new ProductSaleImpl();
        double expResult = 0.0;
        double result = instance.AverageSales(productSales);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MaxSale method, of class ProductSale.
     */
    @Test
    public void testMaxSale() {
        System.out.println("MaxSale");
        int[][] productSales = null;
        ProductSale instance = new ProductSaleImpl();
        int expResult = 0;
        int result = instance.MaxSale(productSales);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MinSale method, of class ProductSale.
     */
    @Test
    public void testMinSale() {
        System.out.println("MinSale");
        int[][] productSales = null;
        ProductSale instance = new ProductSaleImpl();
        int expResult = 0;
        int result = instance.MinSale(productSales);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ProductSaleImpl implements ProductSale {

        public int TotalSales(int[][] productSales) {
            return 0;
        }

        public double AverageSales(int[][] productSales) {
            return 0.0;
        }

        public int MaxSale(int[][] productSales) {
            return 0;
        }

        public int MinSale(int[][] productSales) {
            return 0;
        }
    }

    public class ProductSaleImpl implements ProductSale {

        public int TotalSales(int[][] productSales) {
            return 0;
        }

        public double AverageSales(int[][] productSales) {
            return 0.0;
        }

        public int MaxSale(int[][] productSales) {
            return 0;
        }

        public int MinSale(int[][] productSales) {
            return 0;
        }
    }
    
}

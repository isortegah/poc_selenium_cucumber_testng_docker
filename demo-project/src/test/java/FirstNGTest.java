/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.isortegah.poc_setecudo.IntegerArithmetic;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author isortegah
 */
public class FirstNGTest {
    
    public FirstNGTest() {
        System.out.println("Instancia de la clase.");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception { 
    }
    
   @Test
   public void testIntegerArithmeticMultiplyIntegers()
   {
        final IntegerArithmetic instance = new IntegerArithmetic();
        final int[] integers = {4, 5, 6};
        final int expectedProduct = 4 * 5 * 6;
        final int product = instance.multiplyIntegers(integers);
        //element.submit();
        assertEquals(product, expectedProduct);
   }
}

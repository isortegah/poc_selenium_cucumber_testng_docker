package com.isortegah.pocselenium;

/**
 *
 * @author ISORTEGAH
 */
public class IntegerArithmetic {

   /** 
    * Provide the product of the provided integers. 
    *  
    * @param integers Integers to be multiplied together for a product. 
    * @return Product of the provided integers. 
    * @throws ArithmeticException Thrown in my product is too small or too large 
    *     to be properly represented by a Java integer. 
    */  
   public int multiplyIntegers(final int ... integers)  
   {  
      int returnInt = 1;  
      for (final int integer : integers)  
      {  
         returnInt *= integer;  
      }  
      return returnInt;  
   }  

    public int multiplyIntegers(int i, int i0, int[] integers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

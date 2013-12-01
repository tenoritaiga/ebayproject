/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ebayproject;

/**
 *
 * @author nicholas
 */
public class SearchDataConverter {
   public static String CurrencyComboboxConversion (String number) {
       String[] data = new String[] {
               "US Dollar (USD)",
                "Australian Dollar (AUD)",
                "Canadian dollar (CAD)",
                "Euro (EUR)",
                "Indian Rupee (INR)",
                "New Taiwan Dollar (TWD)",
                "Pound Sterling (GBP)"
           };
       try {
           Integer i = Integer.parseInt(number);
            return data[i];
       } catch (Exception ex) {
           return data[0];
       }
   }
}

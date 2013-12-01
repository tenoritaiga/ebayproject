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
               "USD",
                "AUD",
                "CAD",
                "EUR",
                "INR",
                "TWD",
                "GBP"
           };
       try {
           Integer i = Integer.parseInt(number);
            return data[i];
       } catch (Exception ex) {
           return data[0];
       }
   }
   
   public static String ConditionComboboxConversion (String number) {
       String[] data = new String[] {
           "New",
           "Used",
           "Unspecified"
       };
       try {
           Integer i = Integer.parseInt(number);
            return data[i];
       } catch (Exception ex) {
           return data[0];
       }
   }
   
   
   
   //Use this in sortOrderType, not itemFilter
   public static String SortByComboboxConversion (String number) {
       String[] data = new String[] {
           "EndTimeSoonest",
           "StartTimeNewest",
           "PricePlusShippingLowest",
           "PricePlusShippingHighest",
           "CurrentPriceHighest",
           "DistanceNearest",   //request must also include buyerPostalCode
           "BestMatch"
       };
       try {
           Integer i = Integer.parseInt(number);
            return data[i];
       } catch (Exception ex) {
           return data[0];
       }
   }
   
   
   
}

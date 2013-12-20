package ebayproject;

import java.text.SimpleDateFormat;
import java.util.Date;

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
   
   public static String convertDateToEbayDateTime(java.util.Date d) {
       SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DDTHH:MM:SS.SSSZ");
       return formatter.format(d);
   }
   
   public static String LocatedInComboboxConversion (String number ) {
       String[] data = new String[] {
           "US",
           "GB",
           "AU",
           "CA",
           "CN"
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

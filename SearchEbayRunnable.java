/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebayproject;

import java.util.ArrayList;
import java.util.HashMap;

import com.ebay.services.client.ClientConfig;
import com.ebay.services.client.FindingServiceClientFactory;
import com.ebay.services.finding.Amount;
import com.ebay.services.finding.FindItemsAdvancedRequest;
import com.ebay.services.finding.FindItemsAdvancedResponse;
import com.ebay.services.finding.FindingServicePortType;
import com.ebay.services.finding.ItemFilter;
import com.ebay.services.finding.ItemFilterType;
import com.ebay.services.finding.ListingInfo;
import com.ebay.services.finding.PaginationInput;
import com.ebay.services.finding.SearchItem;
import com.ebay.services.finding.SellingStatus;
import com.ebay.services.finding.SortOrderType;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author nbevacqu
 */
public class SearchEbayRunnable implements Runnable {

    private HashMap<String, String> searchPatternData;
    private ArrayList<HashMap<String, String>> listOfResults;
    private AtomicInteger numSearchesRemaining;
    private final JList jList1;
    private final JLabel statusLabel;

    public SearchEbayRunnable(HashMap<String, String> searchPatternData, ArrayList<HashMap<String, String>> listOfResults, AtomicInteger numSearchesRemaining, JList jList1, JLabel statusLabel) {
        this.searchPatternData = searchPatternData;
        this.listOfResults = listOfResults;
        this.numSearchesRemaining = numSearchesRemaining;
        this.jList1 = jList1;
        this.statusLabel = statusLabel;
    }
    
    public ItemFilter addItemFilter(ItemFilterType filterType, String value) {
        
        ItemFilter itemfilter = new ItemFilter();
        itemfilter.setName(filterType);
        itemfilter.getValue().add(value);
        
        return itemfilter;
        
    }

    public void run() {

        try {
            ClientConfig config = new ClientConfig();
            config.setApplicationId("TonyMond-5bee-41f6-9f21-424915be5a93");
            FindingServicePortType serviceClient = FindingServiceClientFactory.getServiceClient(config);

            FindItemsAdvancedRequest request = new FindItemsAdvancedRequest();

            if(!searchPatternData.containsKey("keywords") || searchPatternData.get("keywords").isEmpty()) {
                searchPatternData.put("keywords", "test");
            }
            request.setKeywords(searchPatternData.get("keywords"));
            
            PaginationInput pi = new PaginationInput();
            pi.setEntriesPerPage(100);
            pi.setPageNumber(1);
            request.setPaginationInput(pi);
            
            List<ItemFilter> itemFilter = request.getItemFilter();
            
            try {
                boolean b = Boolean.parseBoolean(searchPatternData.get("onlyshowitems_row1_checkbox"));
                if(b) {
                    itemFilter.add(addItemFilter(ItemFilterType.PAYMENT_METHOD, "PayPal"));
                }
            } catch (Exception ex) {}
            
            
            itemFilter.add(addItemFilter(ItemFilterType.HIDE_DUPLICATE_ITEMS,"true"));
            
            request.setSortOrder(getSortOrderFromSearchData(searchPatternData));
            
            itemFilter.add(addItemFilter(ItemFilterType.CURRENCY, getCurrencyStringFromSearchData(searchPatternData)));
            //ItemFilter objFilter1 = addItemFilter(ItemFilterType.AVAILABLE_TO,"US");
            //ItemFilter objFilter2 = addItemFilter(ItemFilterType.LISTING_TYPE,"All");
            //ItemFilter objFilter4 = addItemFilter(ItemFilterType.CURRENCY,"USD");
            
            //If "Best offers" is checked, only show items with best offer
            try {
                String bestOfferEnabled = searchPatternData.get("onlyshowitems_row7_checkbox");
                if(Boolean.parseBoolean(bestOfferEnabled))
                    addItemFilter(ItemFilterType.BEST_OFFER_ONLY,"true");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            
            //If "Free shipping" is checked, only show items with free shipping
            try{
                String freeShippingEnabled = searchPatternData.get("shippingoptions_row1_checkbox");
                if(Boolean.parseBoolean(freeShippingEnabled))
                    addItemFilter(ItemFilterType.FREE_SHIPPING_ONLY,"true");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            
            //If "Local Pickup" is checked, only show items with local pickup
            try{
                String freeShippingEnabled = searchPatternData.get("shippingoptions_row2_checkbox");
                if(Boolean.parseBoolean(freeShippingEnabled))
                    addItemFilter(ItemFilterType.LOCAL_PICKUP_ONLY,"true");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            
            //If "Located In" is checked, only show items located in the selected country
            try{
                String locatedInEnabled = searchPatternData.get("located_row2_checkbox");
                if(Boolean.parseBoolean(locatedInEnabled))
                    //TODO: some stuff here, call converter or something I guess
                    System.out.println("Hey Nick");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            
            String conditionString = searchPatternData.get("item_condition_combobox").trim();
            //System.out.println("item condition string: "+conditionString);
            if(conditionString.equals("0")) {
                // New Items only
                //System.out.println("only new items");
                itemFilter.add(addItemFilter(ItemFilterType.CONDITION, "1000"));
            } else if(conditionString.equals("1")) {
                // Used Items only
                //System.out.println("only used items");
                itemFilter.add(addItemFilter(ItemFilterType.CONDITION, "3000"));
            } else {
                // if unspecified then dont add item filter
            }
            
            List<SearchItem> items = new ArrayList<SearchItem>();
            
            System.out.println("making request ");
            FindItemsAdvancedResponse result = serviceClient.findItemsAdvanced(request);
            System.out.println("Ack = "+result.getAck());
            //System.out.println("Found " + result.getSearchResult().getCount() + " items.");
            items.addAll(result.getSearchResult().getItem());
            int totalPages = result.getPaginationOutput().getTotalPages();
            System.out.println("total entries = "+result.getPaginationOutput().getTotalEntries());
            
            // repeat multiple times to get all entries
            for(int i = 1; i < totalPages; i++) {
                pi.setPageNumber(i);
                result = serviceClient.findItemsAdvanced(request);
                items.addAll(result.getSearchResult().getItem());
                
                //System.out.println("Ack = "+result.getAck());
                //System.out.println("Found " + result.getSearchResult().getCount() + " items.");
                
                if(result.getSearchResult().getItem().isEmpty())
                    break;
            }
            
            
            ArrayList<HashMap<String, String>> listOfResults_temp = new ArrayList<HashMap<String, String>>();
            for (SearchItem item : items) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("name", item.getTitle());
                //hm.put("name","name");
                hm.put("image", item.getGalleryURL());
                System.out.println(item);
                ListingInfo listing_info = item.getListingInfo();
                SellingStatus selling_status = item.getSellingStatus();
                Amount amount = selling_status.getConvertedCurrentPrice();
                //System.out.println("currencyID: "+amount.getCurrencyId());
                //System.out.println("value: "+amount.getValue());
                
                if(!priceInValidRange(amount.getValue(), searchPatternData))
                    continue;
                
                hm.put("price", ""+amount.getValue()+" "+amount.getCurrencyId());
                hm.put("itemId", item.getItemId());
                hm.put("url", item.getViewItemURL());
                listOfResults_temp.add(hm);
            }
            
            // do filtering of listOfResultsTemp here by itemId
            Helpers.filterEbaySearchResultsByItemFilter(listOfResults_temp);
            
            synchronized(this.listOfResults) {
                this.listOfResults.addAll(listOfResults_temp);
            }
        } catch (Exception e) {
            System.err.println("Oops, something bad happened while trying to run the query...");
            e.printStackTrace();
        } finally {
            int numLeft = this.numSearchesRemaining.decrementAndGet();
            if(numLeft == 0) {
                jList1.setEnabled(true);
                this.statusLabel.setText("");
            }
        }

    }

    private boolean priceInValidRange(double value, HashMap<String, String> searchPatternData) {
        try {
            boolean checkboxEnabled = Boolean.parseBoolean(searchPatternData.get("priceConstraintsCheckbox"));
            if(checkboxEnabled) {
                double price1 = Double.parseDouble(searchPatternData.get("priceConstraintsField1"));
                double price2 = Double.parseDouble(searchPatternData.get("priceConstraintsField1"));
                
                if(value < price1 || value > price2)
                    return false;
            }
        } catch (Exception ex) {}
        
        return true;
    }

    private SortOrderType getSortOrderFromSearchData(HashMap<String, String> searchPatternData) {
        /*
         * Time: Ending Soonest
         * Time: Newly Listed
         * Price + Shipping: Lowest First
         * Price + Shipping: Highest First
        Price: Highest First
         * Distance: Nearest First
         * Best Match
         */
        
        SortOrderType[] orders = new SortOrderType[] {
            SortOrderType.END_TIME_SOONEST, 
            SortOrderType.START_TIME_NEWEST,
            SortOrderType.PRICE_PLUS_SHIPPING_LOWEST, 
            SortOrderType.PRICE_PLUS_SHIPPING_HIGHEST,
            SortOrderType.CURRENT_PRICE_HIGHEST, 
            SortOrderType.DISTANCE_NEAREST, 
            SortOrderType.BEST_MATCH
        };
        try {
            int sortOrder = Integer.parseInt(searchPatternData.get("sort_results_combobox"));
            return orders[sortOrder];
        } catch (Exception ex) {}
        
        return SortOrderType.BEST_MATCH;
    }

    private String getCurrencyStringFromSearchData(HashMap<String, String> searchPatternData) {
        /*
        US Dollar (USD)
        Australian Dollar (AUD)
        Canadian dollar (CAD)
        Euro (EUR)
        Indian Rupee (INR)
        New Taiwan Dollar (TWD)
        Pound Sterling (GBP)
        */
        
        String[] currencies = new String[] {"USD", "AUD", "CAD", "EUR", "INR", "TWD", "GBP"};
        try {
            int currencySelection = Integer.parseInt(searchPatternData.get("currency_combobox"));
            return currencies[currencySelection];
        } catch (Exception ex) {}
        
        return "USD";
    }
}

package ebayproject;

/*
Copyright (c) 2011 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and 
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent 
version thereof released by eBay.  The then-current version of the License 
can be found at https://www.codebase.ebay.com/Licenses.html and in the 
eBaySDKLicense file that is under the eBay SDK install directory.
*/

import java.util.List;

import com.ebay.services.client.ClientConfig;
import com.ebay.services.client.FindingServiceClientFactory;
import com.ebay.services.finding.FindItemsByKeywordsRequest;
import com.ebay.services.finding.FindItemsByKeywordsResponse;
import com.ebay.services.finding.FindingServicePortType;
import com.ebay.services.finding.PaginationInput;
import com.ebay.services.finding.SearchItem;

/**
 * A sample to show eBay Finding servcie call using the simplied interface 
 * provided by the findingKit.
 * 
 * @author boyang
 * 
 */
public class FindItem {

    // Basic service call flow:
    // 1. Setup client configuration
    // 2. Create service client
    // 3. Create outbound request and setup request parameters
    // 4. Call the operation on the service client and receive inbound response
    // 5. Handle response accordingly
    // Handle exception accordingly if any of the above steps goes wrong.
    public static  void main(String[] args) {
        try {
        	// initialize service end-point configuration
        	ClientConfig config = new ClientConfig();
        	// endpoint address can be overwritten here, by default, production address is used,
        	// to enable sandbox endpoint, just uncomment the following line
        	//config.setEndPointAddress("http://svcs.sandbox.ebay.com/services/search/FindingService/v1");
        	config.setApplicationId("YOUR APPID HERE");

        	//create a service client
            FindingServicePortType serviceClient = FindingServiceClientFactory.getServiceClient(config);
            
            //create request object
            FindItemsByKeywordsRequest request = new FindItemsByKeywordsRequest();
            //set request parameters
            request.setKeywords("harry potter phoenix");
            PaginationInput pi = new PaginationInput();
            pi.setEntriesPerPage(2);
            request.setPaginationInput(pi);
            
            //call service
            FindItemsByKeywordsResponse result = serviceClient.findItemsByKeywords(request);
            
            //output result
            System.out.println("Ack = "+result.getAck());
            System.out.println("Find " + result.getSearchResult().getCount() + " items." );
            List<SearchItem> items = result.getSearchResult().getItem();
            for(SearchItem item : items) {
            	System.out.println(item.getTitle());
            }
            
        } catch (Exception ex) {
        	// handle exception if any
            ex.printStackTrace();
        }
    }
}

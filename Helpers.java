/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebayproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author nbevacqu
 */
public class Helpers {
    public synchronized static boolean serializeListOfHashMaps(File file, ArrayList<HashMap<String, String>> fileObj) {
        try {
            System.out.println(String.format("serializing list of maps: %d maps", fileObj.size()));
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(fileObj);
            s.flush();
            s.close();
            System.out.println("saved list of maps");
            return true;
        } catch (Exception ex) {
            System.err.println("could not save changes");
            return false;
        }
    }
    
    public synchronized static void filterEbaySearchResultsByItemFilter(ArrayList<HashMap<String, String>> results) {
        HashMap<String, Date> previouslySeenItems = null;
        File file = new File("previouslySeenIds.data");
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream s = new ObjectInputStream(f);
            previouslySeenItems = (HashMap<String, Date>) s.readObject();
            s.close();
        } catch (Exception ex) {
            System.err.println("could not find list of previously seen items");
            previouslySeenItems = new HashMap<String, Date>();
        }
        
        ArrayList<String> expiredPreviouslySeenItems = new ArrayList<String>();
        for(String s : previouslySeenItems.keySet()) {
            Date d = previouslySeenItems.get(s);
            
            // if d is too old (> 60 days?)
            // add s to expiredPreviouslySeenItems
            // for now always expire seen items so we dont run out of them
            expiredPreviouslySeenItems.add(s);
        }
        
        for(String s : expiredPreviouslySeenItems) {
            previouslySeenItems.remove(s);
        }
        
        
        ArrayList<HashMap<String, String>> itemsToRemove = new ArrayList<HashMap<String, String>>();
        for(HashMap<String, String> hm : results) {
            if(!hm.containsKey("itemId")) {
                itemsToRemove.add(hm);
            } else {
                String itemId = hm.get("itemId");
                if(previouslySeenItems.containsKey(itemId)) {
                    itemsToRemove.add(hm);
                }
                
                previouslySeenItems.put(itemId, new Date());
            }
        }
        
        results.removeAll(itemsToRemove);
                
        try {
            System.out.println(String.format("serializing list of previously seen items"));
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(previouslySeenItems);
            s.flush();
            s.close();
            System.out.println("saved list of previously seen items");
        } catch (Exception ex) {
            System.err.println("could not save changes to list of previously seen items");
        }
    }
}

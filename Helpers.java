/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebayproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nbevacqu
 */
public class Helpers {
    public synchronized static void serializeListOfHashMaps(File file, ArrayList<HashMap<String, String>> fileObj) {
        try {
            System.out.println(String.format("serializing list of maps: %d maps", fileObj.size()));
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(fileObj);
            s.flush();
            s.close();
            System.out.println("saved search patterns");
        } catch (Exception ex) {
            System.err.println("could not save changes");
        }
    }
}

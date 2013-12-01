/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ebayproject;

import java.util.HashMap;
import javax.swing.JTextField;

/**
 *
 * @author nicholas
 */
public class EditFrameDataHandling {
    public static void RestoreFieldData(JTextField tf, HashMap<String, String> data, String fieldName) {
        if(data.containsKey(fieldName)) {
            tf.setText(data.get(fieldName));
        }
    }
    
    public static void SaveFieldData(JTextField tf, HashMap<String, String> data, String fieldName) {
        data.put(fieldName, tf.getText());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ebayproject;

import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
    
    public static void RestoreFieldData(JCheckBox cb, HashMap<String, String> data, String fieldName) {
        try {
            if(data.containsKey(fieldName)) {
                cb.setSelected(Boolean.parseBoolean(data.get(fieldName)));
            }
        } catch (Exception ex) {
            cb.setSelected(false);
        }
    }
    
    public static void RestoreFieldData(JComboBox cb, HashMap<String, String> data, String fieldName) {
        try {
            if(data.containsKey(fieldName)) {
                cb.setSelectedIndex(Integer.parseInt(data.get(fieldName)));
            }
        } catch (Exception ex) {
            cb.setSelectedIndex(0);
        }
    }
    
    public static void SaveFieldData(JTextField tf, HashMap<String, String> data, String fieldName) {
        data.put(fieldName, tf.getText());
    }
    
    public static void SaveFieldData(JCheckBox cb, HashMap<String, String> data, String fieldName) {
        if(cb.isSelected()) {
            data.put(fieldName, "true");
        } else {
            data.put(fieldName, "false");
        }
    }
    
    public static void SaveFieldData(JComboBox cb, HashMap<String, String> data, String fieldName) {
        data.put(fieldName, ""+cb.getSelectedIndex());
    }
}

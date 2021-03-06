/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebayproject;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;

/**
 * This class is the main starting point. The JFrame created serves as the main 
 * interface for user interaction. When creating/displaying other windows, this 
 * object is passed in as a reference
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        // call autogenerated GUI component creation code
        initComponents();
        
        // load any saved search patterns
        if(this.searializedSearchPatternsFile.exists()) {
            try {
                FileInputStream f = new FileInputStream(this.searializedSearchPatternsFile);
                ObjectInputStream s = new ObjectInputStream(f);
                ArrayList<HashMap<String, String>> fileObj = (ArrayList<HashMap<String, String>>) s.readObject();
                s.close();
                this.searchPatterns = fileObj;
                System.out.println(String.format("found %d search patterns in file", searchPatterns.size()));
            } catch (Exception ex) {
                System.err.println("Could not read/find pre-existing saved search patterns file");
                this.searchPatterns = new ArrayList<HashMap<String, String>>();
            }
        } else {
            this.searchPatterns = new ArrayList<HashMap<String, String>>();
        }
        
        final JButton deleteButton = this.deleteSearchPatternButton;
        final JButton searchButton = this.performSearchButton;
        final JButton editButton = this.editSearchPatternButton;
        
        // this runnable enables/disables buttons depending on the number of checkboxes selected if any
        checkBoxSelectedRunnable = new Runnable() {
            public void run() {
                int numSelected = 0;
                
                synchronized(checkboxes) {
                    for(JCheckBox cb : checkboxes) {
                        if(cb.isSelected())
                            numSelected++;
                    }
                }
                
                editButton.setEnabled(false);
                deleteButton.setEnabled(false);
                searchButton.setEnabled(false);
                
                if(numSelected == 0) {
                    return;
                }
                
                deleteButton.setEnabled(true);
                searchButton.setEnabled(true);
                
                if(numSelected == 1) {
                    editButton.setEnabled(true);
                }
            }
        };
        
        // for each saved search pattern, display its name and a check box
        synchronized(searchPatterns) {
            for(HashMap<String, String> hm : searchPatterns) {
                this.jPanel1.add(new HomeSelection(hm, this.checkboxes, checkBoxSelectedRunnable, mapCheckboxToSearchPattern));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editSearchPatternButton = new javax.swing.JButton();
        deleteSearchPatternButton = new javax.swing.JButton();
        performSearchButton = new javax.swing.JButton();
        addSearchPatternButton = new javax.swing.JButton();
        openSavedSearchResultButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        selectAllButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editSearchPatternButton.setText("Edit Search Pattern");
        editSearchPatternButton.setEnabled(false);
        editSearchPatternButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSearchPatternButtonActionPerformed(evt);
            }
        });

        deleteSearchPatternButton.setText("Delete Search Patten");
        deleteSearchPatternButton.setEnabled(false);
        deleteSearchPatternButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSearchPatternButtonActionPerformed(evt);
            }
        });

        performSearchButton.setText("Perform Search");
        performSearchButton.setEnabled(false);
        performSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performSearchButtonActionPerformed(evt);
            }
        });

        addSearchPatternButton.setText("Add Search Patten");
        addSearchPatternButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSearchPatternButtonActionPerformed(evt);
            }
        });

        openSavedSearchResultButton.setText("Open Saved Search Result");
        openSavedSearchResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSavedSearchResultButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ebay Saved Searches");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        selectAllButton.setText("Select All");
        selectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openSavedSearchResultButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addSearchPatternButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(performSearchButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteSearchPatternButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editSearchPatternButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectAllButton))
                        .addContainerGap(322, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(selectAllButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editSearchPatternButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteSearchPatternButton)
                        .addGap(18, 18, 18)
                        .addComponent(performSearchButton)
                        .addGap(18, 18, 18)
                        .addComponent(addSearchPatternButton)
                        .addGap(18, 18, 18)
                        .addComponent(openSavedSearchResultButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(362, 362, 362))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editSearchPatternButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSearchPatternButtonActionPerformed
        HashMap<String, String> map = null;
        for(JCheckBox cb : checkboxes) {
            if(cb.isSelected()) {
                // get associated search pattern data
                map = this.mapCheckboxToSearchPattern.get(cb).getData();
            }
        }
        if(map != null) {
            // serialize data and update displayed labels
            Runnable serializeDataRunnable = new Runnable() {
                public void run() {
                    Helpers.serializeListOfHashMaps(searializedSearchPatternsFile, searchPatterns);
                    for(HomeSelection hs : mapCheckboxToSearchPattern.values())
                        hs.updateLabels();
                }
            };
            // create a new edit frame to allow editing of search pattern
            EditFrame ef = new EditFrame(this, map, serializeDataRunnable);
            ef.setVisible(true);
        }
    }//GEN-LAST:event_editSearchPatternButtonActionPerformed

    // delete the search pattern
    private void deleteSearchPatternButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSearchPatternButtonActionPerformed
        System.out.println("delete button pressed");
        ArrayList<HashMap<String, String>> toRemove = new ArrayList<HashMap<String, String>>();
        ArrayList<Component> componentsToRemove = new ArrayList<Component>();
        
        synchronized(checkboxes) {
            for(JCheckBox cb : checkboxes) {
                if(cb.isSelected()) {
                    toRemove.add(this.mapCheckboxToSearchPattern.get(cb).getData());
                    componentsToRemove.add(this.mapCheckboxToSearchPattern.get(cb));
                }
            }
        }
        
        this.searchPatterns.removeAll(toRemove);
        for(Component c : componentsToRemove) {
            this.jPanel1.remove(c);
            if(c instanceof HomeSelection) {
                ((HomeSelection)c).delete();
            }
        }
        this.jPanel1.repaint();
        this.jPanel1.updateUI();
        // serialize search patterns without deleted items
        Helpers.serializeListOfHashMaps(searializedSearchPatternsFile, searchPatterns);
    }//GEN-LAST:event_deleteSearchPatternButtonActionPerformed

    private void performSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performSearchButtonActionPerformed
        try {
            ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
            
            // find search patterns that were selected at the time
            synchronized(checkboxes) {
                for(JCheckBox cb : checkboxes) {
                    if(cb.isSelected()) {
                        HomeSelection hs = this.mapCheckboxToSearchPattern.get(cb);
                        list.add(hs.getData());
                    }
                }
            }
            // display results
            ResultsFrame rf = new ResultsFrame(this, list);
            //ResultsFrame rf = new ResultsFrame(this, this.searchPatterns);
            rf.setVisible(true);
        } catch (Exception ex) {
            System.err.println("could not show results frame");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_performSearchButtonActionPerformed

    private void addSearchPatternButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSearchPatternButtonActionPerformed
        System.out.println("adding new search pattern");
        HashMap<String, String> hm = new HashMap<String, String>();
        this.searchPatterns.add(hm);
        hm.put("name", "new search pattern");
        this.jPanel1.add(new HomeSelection(hm, this.checkboxes, checkBoxSelectedRunnable, mapCheckboxToSearchPattern));
        Helpers.serializeListOfHashMaps(this.searializedSearchPatternsFile, this.searchPatterns);
        this.jPanel1.repaint();
        this.jPanel1.updateUI();
        //javax.swing.SwingUtilities.invokeLater(checkBoxSelectedRunnable);
    }//GEN-LAST:event_addSearchPatternButtonActionPerformed

    private void selectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllButtonActionPerformed
        // TODO add your handling code here:
        for(JCheckBox cb : checkboxes) {
            cb.setSelected(true);
            //this.checkBoxSelectedRunnable.run();
            javax.swing.SwingUtilities.invokeLater(checkBoxSelectedRunnable);
        }
    }//GEN-LAST:event_selectAllButtonActionPerformed

    private void openSavedSearchResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSavedSearchResultButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int retValue = fc.showOpenDialog(this);
        if(retValue == JFileChooser.APPROVE_OPTION)
        {
            File savedSearchResultsFile = fc.getSelectedFile();
            ResultsFrame rf = new ResultsFrame(this, savedSearchResultsFile);
            rf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_openSavedSearchResultButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            Logger l = Logger.getRootLogger();
            l.setLevel(Level.ERROR);
            l.addAppender(new ConsoleAppender(new SimpleLayout(), ConsoleAppender.SYSTEM_OUT));
        } catch (Exception ex) {}
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    // runnable to enable / disable buttons
    private Runnable checkBoxSelectedRunnable;
    // list of saved search patterns (each dictionary/hashmap is a search pattern)
    private ArrayList<HashMap<String, String>> searchPatterns;
    // maps checkboxes to the search pattern they represent
    private HashMap<JCheckBox, HomeSelection> mapCheckboxToSearchPattern = new HashMap<JCheckBox, HomeSelection>();
    // file to save search patterns in
    private File searializedSearchPatternsFile = new File("searchPatterns.data");
    // list of checkboxes for each search pattern
    private ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSearchPatternButton;
    private javax.swing.JButton deleteSearchPatternButton;
    private javax.swing.JButton editSearchPatternButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openSavedSearchResultButton;
    private javax.swing.JButton performSearchButton;
    private javax.swing.JButton selectAllButton;
    // End of variables declaration//GEN-END:variables
}

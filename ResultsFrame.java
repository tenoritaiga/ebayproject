package ebayproject;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nbevacqu
 */
public class ResultsFrame extends javax.swing.JFrame {

    /**
     * Creates new form ResultsFrame
     */
    public ResultsFrame() {
        initComponents();
    }
    
    private List< HashMap<String, String> > currentlyDisplayedResults = null;
    private JFrame homeWindow;
    private ArrayList<HashMap<String, String>> searchData;
    private ArrayList<ArrayList<HashMap<String, String>>> searchResults = new ArrayList<ArrayList<HashMap<String, String>>>();
    
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    
    private MouseListener jtableMouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getClickCount() >= 2) {
                    int selectedRow = 0;
                    synchronized(jTable1) {
                        selectedRow = jTable1.getSelectedRow();
                    }
                    
                    HashMap<String, String> hm;
                    synchronized(currentlyDisplayedResults) {
                        hm = currentlyDisplayedResults.get(selectedRow);
                    }
                    
                    String url = (String) hm.get("url");
                    System.out.println(url);
                    try {
                        URL url1 = new URL(url);
                        Desktop d = Desktop.getDesktop();
                        d.browse(new URI(url1.toString()));
                        
                    } catch (Exception ex) {
                        statusLabel.setText("could not open url for item");
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        };
    
    // invoked when loading saved search results
    public ResultsFrame(final JFrame homeWindow, final File savedSearchResultsFile) {
        initComponents();
        this.homeWindow = homeWindow;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(homeWindow != null)
            homeWindow.setVisible(false);
        
        this.saveResultsButton.setEnabled(false);
        this.statusLabel.setText("trying to load saved search results from "+savedSearchResultsFile);
        this.statusLabel.repaint();
        this.statusLabel.updateUI();
        this.jTable1.setEnabled(false);
        
        this.jTable1.addMouseListener(jtableMouseListener);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                threadPool.shutdown();
                if(homeWindow != null)
                    homeWindow.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
        });
        jList1.setListData(new String[0]);
        
        // try and load data here
        final DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel();
        
        threadPool.submit(new Runnable() {
            public void run() {
                try {
                    FileInputStream f = new FileInputStream(savedSearchResultsFile);
                    ObjectInputStream s = new ObjectInputStream(f);
                    ArrayList<HashMap<String, String>> data = (ArrayList<HashMap<String, String>>) s.readObject();
                    s.close();
                    
                    final AtomicInteger numLeft = new AtomicInteger(data.size());
                    currentlyDisplayedResults = data;
                    for(HashMap<String, String> rowResult : data) {
                        final Object[] objArr = new Object[3];
                        objArr[0] = rowResult.get("name");
                        objArr[1] = rowResult.get("image");
                        objArr[2] = rowResult.get("price");
                        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                dtm.insertRow(jTable1.getRowCount(),objArr);
                                if(numLeft.decrementAndGet() == 0)
                                {
                                    statusLabel.setText("finished loading saved search results");
                                    statusLabel.repaint();
                                    statusLabel.updateUI();
                                    jTable1.setEnabled(true);
                                }
                            }
                        });
                    }
                } catch (Exception ex) {
                    String errString = "Could not load saved search results from file";
                    System.err.println(errString);
                    statusLabel.setText(errString);
                    statusLabel.repaint();
                    statusLabel.updateUI();
                }
            }
        });
    }
    
    public ResultsFrame(final JFrame homeWindow, ArrayList<HashMap<String, String>> data) {
        initComponents();
        this.homeWindow = homeWindow;
        this.searchData = data;
        this.saveResultsButton.setEnabled(false);
        if(data == null)
            System.err.println("data null in results frame");
        if(homeWindow != null)
            homeWindow.setVisible(false);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                threadPool.shutdown();
                if(homeWindow != null)
                    homeWindow.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
        });
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                statusLabel.setText("performing search now");
            }
        });
        
        final AtomicInteger numSearchesRemaining = new AtomicInteger(data.size());
        final String[] names = new String[data.size()];
        for(int i = 0; i < data.size(); i++) {
            HashMap<String, String> d = data.get(i);
            names[i] = d.get("name");
            ArrayList<HashMap<String, String>> listofResultHashMaps = new ArrayList<HashMap<String, String>>();
            
            threadPool.submit(new SearchEbayRunnable(d, listofResultHashMaps, numSearchesRemaining, jList1, statusLabel));
            searchResults.add(listofResultHashMaps);
        }
        
        jList1.setEnabled(false);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jList1.setListData(names);
            }
        });
        
        jTable1.addMouseListener(jtableMouseListener);
        
        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                statusLabel.setText("loading results");
                statusLabel.repaint();
                statusLabel.updateUI();
                int selectedIndex = -1;
                
                synchronized(jList1) {
                    selectedIndex = jList1.getSelectedIndex();
                }
                
                if(selectedIndex != -1) {
                    ArrayList<HashMap<String,String>> listOfResults = null;
                    
                    synchronized(searchResults) {
                        listOfResults = searchResults.get(selectedIndex);
                    }
                    
                    synchronized(listOfResults) {
                        
                        final AtomicInteger numLeft = new AtomicInteger(listOfResults.size());
                        // populate table using results
                        final DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                        int rc = dtm.getRowCount();
                        while(rc > 0) {
                            dtm.removeRow(rc-1);
                            rc--;
                        }
                        
                        if(listOfResults.isEmpty())
                            statusLabel.setText("No results to display");
                        
                        currentlyDisplayedResults = listOfResults;
                        for(HashMap<String, String> rowResult : listOfResults) {
                            synchronized(rowResult) {
                                final Object[] objArr = new Object[3];
                                objArr[0] = rowResult.get("name");
                                objArr[1] = rowResult.get("image");
                                objArr[2] = rowResult.get("price");
                                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        dtm.insertRow(jTable1.getRowCount(),objArr);
                                        if(numLeft.decrementAndGet() == 0) {
                                            statusLabel.setText("");
                                            saveResultsButton.setEnabled(true);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
                
                //statusLabel.setText("");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        statusLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        saveResultsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Image", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setCellRenderer(new ebayproject.ImageRenderer());
        }

        saveResultsButton.setText("Save Results");
        saveResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveResultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveResultsButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, Short.MAX_VALUE))
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(saveResultsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveResultsButtonActionPerformed
        int selectedIndex = -1;

        synchronized(jList1) {
            selectedIndex = jList1.getSelectedIndex();
        }
        
        if(selectedIndex == -1) {
            statusLabel.setText("cannot save results if no search pattern is selected");
            statusLabel.repaint();
            statusLabel.updateUI();
            return;
        }

        statusLabel.setText("select file save location");
        statusLabel.repaint();
        statusLabel.updateUI();
        
        // display save dialog box here
        JFileChooser fc = new JFileChooser();
        int retValue = fc.showSaveDialog(this);
        File saveFile = null;
        
        if(retValue == JFileChooser.APPROVE_OPTION) {
            saveFile = fc.getSelectedFile();
        }
        
        if(saveFile == null) {
            statusLabel.setText("Error: can not retrieve file to save results to");
            System.err.println("can not retrieve file to save results to");
            statusLabel.repaint();
            statusLabel.updateUI();
            return;
        }
        
        ArrayList<HashMap<String,String>> listOfResults = null;

        synchronized(searchResults) {
            listOfResults = searchResults.get(selectedIndex);
        }
        
        boolean b;
        synchronized(listOfResults) {
            b = Helpers.serializeListOfHashMaps(saveFile, listOfResults);
        }
        
        if(b) {
            statusLabel.setText("Results successfully saved to "+saveFile);
            System.err.println("Results successfully saved to "+saveFile);
            statusLabel.repaint();
            statusLabel.updateUI();
        } else {
            statusLabel.setText("Error: could not save results to "+saveFile);
            System.err.println("Error: could not save to "+saveFile);
            statusLabel.repaint();
            statusLabel.updateUI();
        }
    }//GEN-LAST:event_saveResultsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ResultsFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton saveResultsButton;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}

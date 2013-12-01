package ebayproject;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
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
    
    private JFrame homeWindow;
    private ArrayList<HashMap<String, String>> searchData;
    private ArrayList<ArrayList<HashMap<String, String>>> searchResults = new ArrayList<ArrayList<HashMap<String, String>>>();
    
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    
    public ResultsFrame(final JFrame homeWindow, ArrayList<HashMap<String, String>> data) {
        initComponents();
        this.homeWindow = homeWindow;
        this.searchData = data;
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
                                        if(numLeft.decrementAndGet() == 0)
                                            statusLabel.setText("");
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
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new ebayproject.ImageRenderer());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, Short.MAX_VALUE))
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}

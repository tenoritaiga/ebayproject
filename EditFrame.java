/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebayproject;

import static ebayproject.EditFrameDataHandling.RestoreFieldData;
import static ebayproject.EditFrameDataHandling.SaveFieldData;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author nbevacqu
 */
public class EditFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditFrame
     */
    public EditFrame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public EditFrame(final JFrame homeWindow, HashMap<String, String> hm, Runnable serializeDataRunnable) {
        initComponents();
        homeWindow.setVisible(false);
        this.serializeDataRunnable = serializeDataRunnable;
        this.data = hm;
        this.homeWindow = homeWindow;
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
        
        RestoreFieldData(searchPatternName, data, "name");
        RestoreFieldData(keywords, data, "keywords");
        RestoreFieldData(keywords_specfier_combobox, data, "keywords_specfier_combobox");
        RestoreFieldData(excludeKeywordsTextfield, data, "excludeKeywordsTextfield");
        RestoreFieldData(searchincluding_row1_checkbox, data, "searchincluding_row1_checkbox");
        RestoreFieldData(searchincluding_row2_checkbox, data, "searchincluding_row2_checkbox");
        RestoreFieldData(searchincluding_row3_checkbox, data, "searchincluding_row3_checkbox");
        RestoreFieldData(priceConstraintsCheckbox, data, "priceConstraintsCheckbox");
        RestoreFieldData(this.priceConstraintsField1, data, "priceConstraintsField1");
        RestoreFieldData(this.priceConstraintsField2, data, "priceConstraintsField2");
        RestoreFieldData(buyingformats_row1_checkbox, data, "buyingformats_row1_checkbox");
        RestoreFieldData(buyingformats_row2_checkbox, data, "buyingformats_row2_checkbox");
        RestoreFieldData(buyingformats_row3_checkbox, data, "buyingformats_row3_checkbox");
        RestoreFieldData(item_condition_combobox, data, "item_condition_combobox");
        RestoreFieldData(onlyshowitems_row1_checkbox, data, "onlyshowitems_row1_checkbox");
        RestoreFieldData(onlyshowitems_row2_checkbox, data, "onlyshowitems_row2_checkbox");
        RestoreFieldData(onlyshowitems_row2_field1, data, "onlyshowitems_row2_field1");
        RestoreFieldData(onlyshowitems_row2_field2, data, "onlyshowitems_row2_field2");
        RestoreFieldData(onlyshowitems_row3_checkbox, data, "onlyshowitems_row3_checkbox");
        RestoreFieldData(onlyshowitems_row3_field1, data, "onlyshowitems_row3_field1");
        RestoreFieldData(onlyshowitems_row3_field2, data, "onlyshowitems_row3_field2");
        RestoreFieldData(onlyshowitems_row4_checkbox, data, "onlyshowitems_row4_checkbox");
        RestoreFieldData(onlyshowitems_row4_field1, data, "onlyshowitems_row4_field1");
        RestoreFieldData(onlyshowitems_row4_field2, data, "onlyshowitems_row4_field2");
        RestoreFieldData(onlyshowitems_row5_checkbox, data, "onlyshowitems_row5_checkbox");
        RestoreFieldData(onlyshowitems_row6_checkbox, data, "onlyshowitems_row6_checkbox");
        RestoreFieldData(onlyshowitems_row7_checkbox, data, "onlyshowitems_row7_checkbox");
        RestoreFieldData(shippingoptions_row1_checkbox, data, "shippingoptions_row1_checkbox");
        RestoreFieldData(shippingoptions_row2_checkbox, data, "shippingoptions_row2_checkbox");
        RestoreFieldData(location_row1_checkbox, data, "location_row1_checkbox");
        RestoreFieldData(location_row1_field1, data, "location_row1_field1");
        RestoreFieldData(location_row1_field2, data, "location_row1_field2");
        RestoreFieldData(location_row2_checkbox, data, "location_row2_checkbox");
        RestoreFieldData(location_row2_field1, data, "location_row2_field1");
        RestoreFieldData(location_row3_checkbox, data, "location_row3_checkbox");
        RestoreFieldData(location_row3_field1, data, "location_row3_field1");
        RestoreFieldData(selleroptions_checkbox, data, "selleroptions_checkbox");
        RestoreFieldData(currency_combobox, data, "currency_combobox");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        keywords = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        keywords_specfier_combobox = new javax.swing.JComboBox();
        excludeKeywordsTextfield = new javax.swing.JTextField();
        excludeKeywordsLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categories_combobox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        searchincluding_row1_checkbox = new javax.swing.JCheckBox();
        searchincluding_row2_checkbox = new javax.swing.JCheckBox();
        searchincluding_row3_checkbox = new javax.swing.JCheckBox();
        priceConstraintsCheckbox = new javax.swing.JCheckBox();
        buyingformats_row1_checkbox = new javax.swing.JCheckBox();
        buyingformats_row2_checkbox = new javax.swing.JCheckBox();
        buyingformats_row3_checkbox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        priceConstraintsField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        priceConstraintsField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        item_condition_combobox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        sort_results_combobox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        searchPatternName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        onlyshowitems_row1_checkbox = new javax.swing.JCheckBox();
        onlyshowitems_row2_checkbox = new javax.swing.JCheckBox();
        onlyshowitems_row2_field1 = new javax.swing.JComboBox();
        onlyshowitems_row2_field2 = new javax.swing.JComboBox();
        onlyshowitems_row3_checkbox = new javax.swing.JCheckBox();
        onlyshowitems_row3_field1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        onlyshowitems_row3_field2 = new javax.swing.JTextField();
        onlyshowitems_row4_checkbox = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        onlyshowitems_row4_field1 = new javax.swing.JTextField();
        onlyshowitems_row4_field2 = new javax.swing.JTextField();
        onlyshowitems_row5_checkbox = new javax.swing.JCheckBox();
        onlyshowitems_row6_checkbox = new javax.swing.JCheckBox();
        onlyshowitems_row7_checkbox = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        shippingoptions_row1_checkbox = new javax.swing.JCheckBox();
        shippingoptions_row2_checkbox = new javax.swing.JCheckBox();
        location_row1_checkbox = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        location_row1_field1 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        location_row1_field2 = new javax.swing.JTextField();
        location_row2_checkbox = new javax.swing.JCheckBox();
        location_row2_field1 = new javax.swing.JComboBox();
        location_row3_checkbox = new javax.swing.JCheckBox();
        location_row3_field1 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        selleroptions_checkbox = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        currency_combobox = new javax.swing.JComboBox();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        keywords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordsActionPerformed(evt);
            }
        });

        jLabel1.setText("Keywords:");

        keywords_specfier_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All words, any order", "Any words, any order", "Exact words, exact order", "Exact words, any order" }));
        keywords_specfier_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywords_specfier_comboboxActionPerformed(evt);
            }
        });

        excludeKeywordsLabel.setText("Exclude Words From Search");

        jLabel3.setText("In Category");

        categories_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Categories", "Antiques", "Art", "Baby", "Books", "Business & Industrial", "Cameras & Photo", "Cell Phones & Accessories", "Clothing, Shoes & Accessories", "Coins & Paper Money", "Collectibles", "Computers/Tablets & Networking", "Consumer Electronics", "Crafts", "Dolls & Bears", "DVDs & Movies", "eBay Motors", "Entertainment Memorabilia", "Gift Cards & Coupons", "Health & Beauty", "Home & Garden", "Jewelry & Watches", "Music", "Musical Instruments & Gear", "Pet Supplies", "Pottery & Glass", "Real Estate", "Specialty Services", "Sporting Goods", "Sports Mem, Cards & Fan Shop", "Stamps", "Tickets & Experiences", "Toys & Hobbies", "Travel", "Video Games & Consoles", "Everything Else" }));
        categories_combobox.setEnabled(false);

        jLabel4.setText("Search Including");

        searchincluding_row1_checkbox.setText("Title and Description");
        searchincluding_row1_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchincluding_row1_checkboxActionPerformed(evt);
            }
        });

        searchincluding_row2_checkbox.setText("Completed Listings");
        searchincluding_row2_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchincluding_row2_checkboxActionPerformed(evt);
            }
        });

        searchincluding_row3_checkbox.setText("Sold Listings");
        searchincluding_row3_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchincluding_row3_checkboxActionPerformed(evt);
            }
        });

        priceConstraintsCheckbox.setText("Only Show Items Prices From ");
        priceConstraintsCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                priceConstraintsCheckboxItemStateChanged(evt);
            }
        });
        priceConstraintsCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceConstraintsCheckboxActionPerformed(evt);
            }
        });

        buyingformats_row1_checkbox.setText("Auction");
        buyingformats_row1_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingformats_row1_checkboxActionPerformed(evt);
            }
        });

        buyingformats_row2_checkbox.setText("Buy It Now");
        buyingformats_row2_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingformats_row2_checkboxActionPerformed(evt);
            }
        });

        buyingformats_row3_checkbox.setText("Classifieds");
        buyingformats_row3_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingformats_row3_checkboxActionPerformed(evt);
            }
        });

        jLabel5.setText("Price Constraints");

        priceConstraintsField1.setEnabled(false);
        priceConstraintsField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceConstraintsField1ActionPerformed(evt);
            }
        });

        jLabel6.setText("to $");

        priceConstraintsField2.setEnabled(false);
        priceConstraintsField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceConstraintsField2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Buying Formats");

        jLabel8.setText("Item Condition");

        item_condition_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "New", "Used", "Unspecified" }));

        jLabel9.setText("Sort Results By");

        sort_results_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Time: Ending Soonest", "Time: Newly Listed", "Price + Shipping: Lowest First", "Price + Shipping: Highest First", "Price: Highest First", "Distance: Nearest First", "Best Match" }));

        jLabel10.setText("Name For This Search Pattern");

        searchPatternName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPatternNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(keywords, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keywords_specfier_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchincluding_row1_checkbox)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(categories_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(excludeKeywordsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(excludeKeywordsTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(searchincluding_row2_checkbox)
                    .addComponent(searchincluding_row3_checkbox)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(priceConstraintsCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceConstraintsField1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceConstraintsField2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(item_condition_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buyingformats_row2_checkbox)
                            .addComponent(buyingformats_row1_checkbox))
                        .addGap(116, 116, 116)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sort_results_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buyingformats_row3_checkbox)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(searchPatternName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keywords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(keywords_specfier_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categories_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excludeKeywordsLabel)
                    .addComponent(excludeKeywordsTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchincluding_row1_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchincluding_row2_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchincluding_row3_checkbox)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceConstraintsCheckbox)
                    .addComponent(priceConstraintsField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(priceConstraintsField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buyingformats_row1_checkbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buyingformats_row2_checkbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyingformats_row3_checkbox)
                            .addComponent(jLabel10)
                            .addComponent(searchPatternName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(item_condition_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(sort_results_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Basic Settings", jPanel1);

        jLabel11.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel11.setText("Only Show Items:");

        onlyshowitems_row1_checkbox.setText("From sellers that accept PayPal");
        onlyshowitems_row1_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyshowitems_row1_checkboxActionPerformed(evt);
            }
        });

        onlyshowitems_row2_checkbox.setText("Listings");
        onlyshowitems_row2_checkbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                onlyshowitems_row2_checkboxItemStateChanged(evt);
            }
        });
        onlyshowitems_row2_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyshowitems_row2_checkboxActionPerformed(evt);
            }
        });

        onlyshowitems_row2_field1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ending within", "Ending in more than", "Started within" }));
        onlyshowitems_row2_field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyshowitems_row2_field1ActionPerformed(evt);
            }
        });

        onlyshowitems_row2_field2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 hour", "2 hours", "3 hours", "4 hours", "5 hours", "12 hours", "24 hours", "2 days", "3 days", "4 days", "5 days", "6 days", "7 days" }));

        onlyshowitems_row3_checkbox.setText("Number of bids from");
        onlyshowitems_row3_checkbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                onlyshowitems_row3_checkboxItemStateChanged(evt);
            }
        });
        onlyshowitems_row3_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyshowitems_row3_checkboxActionPerformed(evt);
            }
        });

        jLabel12.setText("to");

        onlyshowitems_row4_checkbox.setText("Number of item listings from");
        onlyshowitems_row4_checkbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                onlyshowitems_row4_checkboxItemStateChanged(evt);
            }
        });
        onlyshowitems_row4_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyshowitems_row4_checkboxActionPerformed(evt);
            }
        });

        jLabel13.setText("to");

        onlyshowitems_row5_checkbox.setText("Items listed as lots");

        onlyshowitems_row6_checkbox.setText("Sale items");

        onlyshowitems_row7_checkbox.setText("Best offer");

        jLabel14.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel14.setText("Shipping Options");

        shippingoptions_row1_checkbox.setText("Free Shipping");

        shippingoptions_row2_checkbox.setText("Local pickup available");

        location_row1_checkbox.setText("Only show items within");
        location_row1_checkbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                location_row1_checkboxItemStateChanged(evt);
            }
        });
        location_row1_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                location_row1_checkboxActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel15.setText("Location Options");

        location_row1_field1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10 miles", "25 miles", "50 miles", "75 miles", "100 miles", "150 miles", "200 miles", "250 miles", "500 miles", "750 miles", "1000 miles", "1500 miles", "2000 miles" }));

        jLabel16.setText("of ZIP code");

        location_row2_checkbox.setText("Only show items within");
        location_row2_checkbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                location_row2_checkboxItemStateChanged(evt);
            }
        });

        location_row2_field1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "United States", "North America", "Worldwide" }));

        location_row3_checkbox.setText("Only show items that ship to");
        location_row3_checkbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                location_row3_checkboxItemStateChanged(evt);
            }
        });

        location_row3_field1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "United States", "North America", "Worldwide" }));

        jLabel17.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel17.setText("Seller Options");

        selleroptions_checkbox.setText("Only show items from sellers with eBay Stores");

        jLabel18.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel18.setText("Currency");

        jLabel19.setText("Preferred currency:");

        currency_combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "US Dollar (USD)", "Australian Dollar (AUD)", "Canadian dollar (CAD)", "Euro (EUR)", "Indian Rupee (INR)", "New Taiwan Dollar (TWD)", "Pound Sterling (GBP)", " ", " ", " " }));
        currency_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currency_comboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selleroptions_checkbox)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(location_row3_checkbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(location_row3_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(location_row2_checkbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(location_row2_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shippingoptions_row2_checkbox)
                    .addComponent(onlyshowitems_row7_checkbox)
                    .addComponent(onlyshowitems_row6_checkbox)
                    .addComponent(onlyshowitems_row5_checkbox)
                    .addComponent(jLabel11)
                    .addComponent(onlyshowitems_row1_checkbox)
                    .addComponent(jLabel14)
                    .addComponent(shippingoptions_row1_checkbox)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currency_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(onlyshowitems_row4_checkbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(onlyshowitems_row4_field1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(location_row1_checkbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(location_row1_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(location_row1_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(onlyshowitems_row4_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(onlyshowitems_row3_checkbox)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(onlyshowitems_row3_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(onlyshowitems_row3_field2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(onlyshowitems_row2_checkbox)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(onlyshowitems_row2_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(onlyshowitems_row2_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(onlyshowitems_row1_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onlyshowitems_row2_checkbox)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(onlyshowitems_row2_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(onlyshowitems_row2_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onlyshowitems_row3_checkbox)
                    .addComponent(onlyshowitems_row3_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(onlyshowitems_row3_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onlyshowitems_row4_checkbox)
                    .addComponent(jLabel13)
                    .addComponent(onlyshowitems_row4_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(onlyshowitems_row4_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(onlyshowitems_row5_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(onlyshowitems_row6_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(onlyshowitems_row7_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shippingoptions_row1_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shippingoptions_row2_checkbox)
                .addGap(11, 11, 11)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location_row1_checkbox)
                    .addComponent(location_row1_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(location_row1_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location_row2_checkbox)
                    .addComponent(location_row2_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location_row3_checkbox)
                    .addComponent(location_row3_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selleroptions_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(currency_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Advanced Settings", jPanel2);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keywordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordsActionPerformed

    private void keywords_specfier_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywords_specfier_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywords_specfier_comboboxActionPerformed

    private void searchincluding_row1_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchincluding_row1_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchincluding_row1_checkboxActionPerformed

    private void searchincluding_row2_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchincluding_row2_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchincluding_row2_checkboxActionPerformed

    private void searchincluding_row3_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchincluding_row3_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchincluding_row3_checkboxActionPerformed

    private void priceConstraintsCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceConstraintsCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceConstraintsCheckboxActionPerformed

    private void buyingformats_row1_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingformats_row1_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingformats_row1_checkboxActionPerformed

    private void buyingformats_row2_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingformats_row2_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingformats_row2_checkboxActionPerformed

    private void buyingformats_row3_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingformats_row3_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingformats_row3_checkboxActionPerformed

    private void priceConstraintsField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceConstraintsField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceConstraintsField1ActionPerformed

    private void priceConstraintsField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceConstraintsField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceConstraintsField2ActionPerformed

    private void searchPatternNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPatternNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchPatternNameActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        SaveFieldData(searchPatternName, data, "name");
        SaveFieldData(keywords, data, "keywords");
        SaveFieldData(keywords_specfier_combobox, data, "keywords_specfier_combobox");
        SaveFieldData(excludeKeywordsTextfield, data, "excludeKeywordsTextfield");
        SaveFieldData(searchincluding_row1_checkbox, data, "searchincluding_row1_checkbox");
        SaveFieldData(searchincluding_row2_checkbox, data, "searchincluding_row2_checkbox");
        SaveFieldData(searchincluding_row3_checkbox, data, "searchincluding_row3_checkbox");
        SaveFieldData(priceConstraintsCheckbox, data, "priceConstraintsCheckbox");
        SaveFieldData(this.priceConstraintsField1, data, "priceConstraintsField1");
        SaveFieldData(this.priceConstraintsField2, data, "priceConstraintsField2");
        SaveFieldData(buyingformats_row1_checkbox, data, "buyingformats_row1_checkbox");
        SaveFieldData(buyingformats_row2_checkbox, data, "buyingformats_row2_checkbox");
        SaveFieldData(buyingformats_row3_checkbox, data, "buyingformats_row3_checkbox");
        SaveFieldData(item_condition_combobox, data, "item_condition_combobox");
        SaveFieldData(onlyshowitems_row1_checkbox, data, "onlyshowitems_row1_checkbox");
        SaveFieldData(onlyshowitems_row2_checkbox, data, "onlyshowitems_row2_checkbox");
        SaveFieldData(onlyshowitems_row2_field1, data, "onlyshowitems_row2_field1");
        SaveFieldData(onlyshowitems_row2_field2, data, "onlyshowitems_row2_field2");
        SaveFieldData(onlyshowitems_row3_checkbox, data, "onlyshowitems_row3_checkbox");
        SaveFieldData(onlyshowitems_row3_field1, data, "onlyshowitems_row3_field1");
        SaveFieldData(onlyshowitems_row3_field2, data, "onlyshowitems_row3_field2");
        SaveFieldData(onlyshowitems_row4_checkbox, data, "onlyshowitems_row4_checkbox");
        SaveFieldData(onlyshowitems_row4_field1, data, "onlyshowitems_row4_field1");
        SaveFieldData(onlyshowitems_row4_field2, data, "onlyshowitems_row4_field2");
        SaveFieldData(onlyshowitems_row5_checkbox, data, "onlyshowitems_row5_checkbox");
        SaveFieldData(onlyshowitems_row6_checkbox, data, "onlyshowitems_row6_checkbox");
        SaveFieldData(onlyshowitems_row7_checkbox, data, "onlyshowitems_row7_checkbox");
        SaveFieldData(shippingoptions_row1_checkbox, data, "shippingoptions_row1_checkbox");
        SaveFieldData(shippingoptions_row2_checkbox, data, "shippingoptions_row2_checkbox");
        SaveFieldData(location_row1_checkbox, data, "location_row1_checkbox");
        SaveFieldData(location_row1_field1, data, "location_row1_field1");
        SaveFieldData(location_row1_field2, data, "location_row1_field2");
        SaveFieldData(location_row2_checkbox, data, "location_row2_checkbox");
        SaveFieldData(location_row2_field1, data, "location_row2_field1");
        SaveFieldData(location_row3_checkbox, data, "location_row3_checkbox");
        SaveFieldData(location_row3_field1, data, "location_row3_field1");
        SaveFieldData(selleroptions_checkbox, data, "selleroptions_checkbox");
        SaveFieldData(currency_combobox, data, "currency_combobox");
        //data.put("name", this.searchPatternName.getText());
        //data.put("keywords", this.keywords.getText());
        if(this.serializeDataRunnable != null)
            this.serializeDataRunnable.run();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void onlyshowitems_row1_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyshowitems_row1_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onlyshowitems_row1_checkboxActionPerformed

    private void onlyshowitems_row2_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyshowitems_row2_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onlyshowitems_row2_checkboxActionPerformed

    private void onlyshowitems_row2_field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyshowitems_row2_field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onlyshowitems_row2_field1ActionPerformed

    private void onlyshowitems_row3_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyshowitems_row3_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onlyshowitems_row3_checkboxActionPerformed

    private void onlyshowitems_row4_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyshowitems_row4_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onlyshowitems_row4_checkboxActionPerformed

    private void location_row1_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_location_row1_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_location_row1_checkboxActionPerformed

    private void currency_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currency_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currency_comboboxActionPerformed

    private void priceConstraintsCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_priceConstraintsCheckboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // enable other 2 components
            this.priceConstraintsField1.setEnabled(true);
            this.priceConstraintsField2.setEnabled(true);
        } else {
            // disable other 2 components
            this.priceConstraintsField1.setEnabled(false);
            this.priceConstraintsField2.setEnabled(false);
        }
    }//GEN-LAST:event_priceConstraintsCheckboxItemStateChanged

    private void onlyshowitems_row2_checkboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_onlyshowitems_row2_checkboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // enable other 2 components
            this.onlyshowitems_row2_field1.setEnabled(true);
            this.onlyshowitems_row2_field2.setEnabled(true);
        } else {
            // disable other 2 components
            this.onlyshowitems_row2_field1.setEnabled(false);
            this.onlyshowitems_row2_field2.setEnabled(false);
        }
    }//GEN-LAST:event_onlyshowitems_row2_checkboxItemStateChanged

    private void onlyshowitems_row3_checkboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_onlyshowitems_row3_checkboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // enable other 2 components
            this.onlyshowitems_row3_field1.setEnabled(true);
            this.onlyshowitems_row3_field2.setEnabled(true);
        } else {
            // disable other 2 components
            this.onlyshowitems_row3_field1.setEnabled(false);
            this.onlyshowitems_row3_field2.setEnabled(false);
        }
    }//GEN-LAST:event_onlyshowitems_row3_checkboxItemStateChanged

    private void onlyshowitems_row4_checkboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_onlyshowitems_row4_checkboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // enable other 2 components
            this.onlyshowitems_row4_field1.setEnabled(true);
            this.onlyshowitems_row4_field2.setEnabled(true);
        } else {
            // disable other 2 components
            this.onlyshowitems_row4_field1.setEnabled(false);
            this.onlyshowitems_row4_field2.setEnabled(false);
        }
    }//GEN-LAST:event_onlyshowitems_row4_checkboxItemStateChanged

    private void location_row1_checkboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_location_row1_checkboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // enable other 2 components
            this.location_row1_field1.setEnabled(true);
            this.location_row1_field2.setEnabled(true);
        } else {
            // disable other 2 components
            this.location_row1_field1.setEnabled(false);
            this.location_row1_field2.setEnabled(false);
        }
    }//GEN-LAST:event_location_row1_checkboxItemStateChanged

    private void location_row2_checkboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_location_row2_checkboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // enable other 2 components
            this.location_row2_field1.setEnabled(true);
        } else {
            // disable other 2 components
            this.location_row2_field1.setEnabled(false);
        }
    }//GEN-LAST:event_location_row2_checkboxItemStateChanged

    private void location_row3_checkboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_location_row3_checkboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // enable other 2 components
            this.location_row3_field1.setEnabled(true);
        } else {
            // disable other 2 components
            this.location_row3_field1.setEnabled(false);
        }
    }//GEN-LAST:event_location_row3_checkboxItemStateChanged

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
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EditFrame().setVisible(true);
            }
        });
    }
    
    
    private Runnable serializeDataRunnable = null;
    private JFrame homeWindow = null;
    private HashMap<String, String> data = new HashMap<String, String>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox buyingformats_row1_checkbox;
    private javax.swing.JCheckBox buyingformats_row2_checkbox;
    private javax.swing.JCheckBox buyingformats_row3_checkbox;
    private javax.swing.JComboBox categories_combobox;
    private javax.swing.JComboBox currency_combobox;
    private javax.swing.JLabel excludeKeywordsLabel;
    private javax.swing.JTextField excludeKeywordsTextfield;
    private javax.swing.JComboBox item_condition_combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField keywords;
    private javax.swing.JComboBox keywords_specfier_combobox;
    private javax.swing.JCheckBox location_row1_checkbox;
    private javax.swing.JComboBox location_row1_field1;
    private javax.swing.JTextField location_row1_field2;
    private javax.swing.JCheckBox location_row2_checkbox;
    private javax.swing.JComboBox location_row2_field1;
    private javax.swing.JCheckBox location_row3_checkbox;
    private javax.swing.JComboBox location_row3_field1;
    private javax.swing.JCheckBox onlyshowitems_row1_checkbox;
    private javax.swing.JCheckBox onlyshowitems_row2_checkbox;
    private javax.swing.JComboBox onlyshowitems_row2_field1;
    private javax.swing.JComboBox onlyshowitems_row2_field2;
    private javax.swing.JCheckBox onlyshowitems_row3_checkbox;
    private javax.swing.JTextField onlyshowitems_row3_field1;
    private javax.swing.JTextField onlyshowitems_row3_field2;
    private javax.swing.JCheckBox onlyshowitems_row4_checkbox;
    private javax.swing.JTextField onlyshowitems_row4_field1;
    private javax.swing.JTextField onlyshowitems_row4_field2;
    private javax.swing.JCheckBox onlyshowitems_row5_checkbox;
    private javax.swing.JCheckBox onlyshowitems_row6_checkbox;
    private javax.swing.JCheckBox onlyshowitems_row7_checkbox;
    private javax.swing.JCheckBox priceConstraintsCheckbox;
    private javax.swing.JTextField priceConstraintsField1;
    private javax.swing.JTextField priceConstraintsField2;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchPatternName;
    private javax.swing.JCheckBox searchincluding_row1_checkbox;
    private javax.swing.JCheckBox searchincluding_row2_checkbox;
    private javax.swing.JCheckBox searchincluding_row3_checkbox;
    private javax.swing.JCheckBox selleroptions_checkbox;
    private javax.swing.JCheckBox shippingoptions_row1_checkbox;
    private javax.swing.JCheckBox shippingoptions_row2_checkbox;
    private javax.swing.JComboBox sort_results_combobox;
    // End of variables declaration//GEN-END:variables
}

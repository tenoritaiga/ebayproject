/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebayproject;

import java.awt.Component;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author nbevacqu
 * adapted from stackoverflow entry
 * http://stackoverflow.com/questions/3222951/java-put-image-in-jtable-cell
 */
public class ImageRenderer extends DefaultTableCellRenderer {
    public ImageRenderer() {
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(value instanceof String) {
            JLabel l;
            Dimension d = new Dimension(150, 150);
            //l = new JLabel(new ImageIcon((String)value));
            //return new JLabel(new ImageIcon((String)"C:\\Users\\Class2015\\Desktop\\better_pandora_hearts_poster.png"));
            try {
                ImageIcon icon;
                //icon = new ImageIcon(new URL("http://images.forwallpaper.com/files/thumbs/preview/113/1131611__friends-forever-golden-retriever-puppi_p.jpg"));
                icon = new ImageIcon(new URL((String)value));
                int imageWidth = icon.getImage().getWidth(null);
                int imageHeight = icon.getImage().getHeight(null);
                d = new Dimension(imageWidth, imageHeight);
                table.setRowHeight(row, imageHeight);
                TableColumn col = table.getColumnModel().getColumn(column);
                col.setWidth(Math.max(imageWidth, col.getWidth()));
                table.repaint();
                //table.updateUI();
                l = new JLabel(icon);
            } catch (Exception ex) {
                l = new JLabel("Could not load image");
                System.err.println(ex);
                ex.printStackTrace(System.err);
            }
            
            l.setMinimumSize(d);
            l.setSize(d);
            l.setMaximumSize(d);
            
            return l;
        } else {
            return new JLabel("No Image Available");
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DrawingToolPanel.java
 *
 * Created on Aug 27, 2011, 11:12:41 AM
 */
package buckley.DrawingTool.gui;

import buckley.DrawingTool.interfaces.Tool;
import buckley.DrawingTool.enums.ToolType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;

/**
 *
 * @author Thunder
 */
public class DrawingToolPanel extends javax.swing.JPanel {
    
    private Point drawStartPoint;
    
    /** Creates new form DrawingToolPanel */
    public DrawingToolPanel() {
        //add instance of each tool
        
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolSelectorPanel = new javax.swing.JPanel();
        toolSelectorLabel = new javax.swing.JLabel();
        toolSelectorComboBox = new javax.swing.JComboBox();
        colorChooserPanel = new javax.swing.JPanel();
        isFilledRadioButton = new javax.swing.JRadioButton();
        undoButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        lineWidthSlider = new javax.swing.JSlider();
        canvas = canvas = new DrawingToolCanvas();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        setMinimumSize(new java.awt.Dimension(150, 150));
        setPreferredSize(new java.awt.Dimension(250, 250));
        setLayout(new java.awt.BorderLayout());

        toolSelectorPanel.setBackground(new java.awt.Color(102, 0, 0));

        toolSelectorLabel.setForeground(new java.awt.Color(255, 102, 0));
        toolSelectorLabel.setText("Tool:");
        toolSelectorPanel.add(toolSelectorLabel);

        toolSelectorComboBox.setBackground(new java.awt.Color(102, 0, 0));
        toolSelectorComboBox.setForeground(new java.awt.Color(255, 102, 0));
        toolSelectorComboBox.setModel(new DefaultComboBoxModel<Tool>(DrawingToolStatus.getInstance().getToolList()));
        toolSelectorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSelectorComboBoxActionPerformed(evt);
            }
        });
        toolSelectorPanel.add(toolSelectorComboBox);

        colorChooserPanel.setBackground(new java.awt.Color(255, 102, 0));
        colorChooserPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        colorChooserPanel.setPreferredSize(new java.awt.Dimension(30, 20));
        colorChooserPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorChooserPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout colorChooserPanelLayout = new javax.swing.GroupLayout(colorChooserPanel);
        colorChooserPanel.setLayout(colorChooserPanelLayout);
        colorChooserPanelLayout.setHorizontalGroup(
            colorChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        colorChooserPanelLayout.setVerticalGroup(
            colorChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        toolSelectorPanel.add(colorChooserPanel);

        isFilledRadioButton.setBackground(new java.awt.Color(102, 0, 0));
        isFilledRadioButton.setForeground(new java.awt.Color(255, 102, 0));
        isFilledRadioButton.setText("Filled");
        isFilledRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isFilledRadioButtonActionPerformed(evt);
            }
        });
        toolSelectorPanel.add(isFilledRadioButton);

        undoButton.setBackground(new java.awt.Color(102, 0, 0));
        undoButton.setForeground(new java.awt.Color(255, 102, 0));
        undoButton.setText("Undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        toolSelectorPanel.add(undoButton);

        clearButton.setBackground(new java.awt.Color(102, 0, 0));
        clearButton.setForeground(new java.awt.Color(255, 102, 0));
        clearButton.setText("Clear");
        toolSelectorPanel.add(clearButton);

        lineWidthSlider.setBackground(new java.awt.Color(102, 0, 0));
        lineWidthSlider.setForeground(new java.awt.Color(255, 102, 0));
        lineWidthSlider.setPreferredSize(new java.awt.Dimension(50, 20));
        toolSelectorPanel.add(lineWidthSlider);

        add(toolSelectorPanel, java.awt.BorderLayout.PAGE_START);

        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvasMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasMousePressed(evt);
            }
        });
        canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvasMouseDragged(evt);
            }
        });
        add(canvas, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void toolSelectorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSelectorComboBoxActionPerformed
    Tool t = (Tool) toolSelectorComboBox.getSelectedItem();
    
    
    DrawingToolStatus dts = DrawingToolStatus.getInstance();
    
    dts.setCurrentTool(t);
    
    //adjust toolselection bar for tooltype
    switch(dts.getCurrentToolType()) {
        case SHAPE_MAKER_TOOL:
            colorChooserPanel.setVisible(true);
            isFilledRadioButton.setVisible(false);
            lineWidthSlider.setVisible(true);
            break;
        case SHAPE_MAKER_TOOL_FILLABLE:
            colorChooserPanel.setVisible(true);
            isFilledRadioButton.setVisible(true);
            lineWidthSlider.setVisible(true);
        case MANIPULATOR_TOOL:
            colorChooserPanel.setVisible(false);
            isFilledRadioButton.setVisible(false);
            lineWidthSlider.setVisible(false);
            break;
        default: 
            break;
    }
    
    repaint();
}//GEN-LAST:event_toolSelectorComboBoxActionPerformed

private void colorChooserPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorChooserPanelMouseClicked
    DrawingToolStatus dts = DrawingToolStatus.getInstance();
    Color newColor = JColorChooser.showDialog(this, "Drawing Color", 
            dts.getCurrentColor());
    dts.setCurrentColor(newColor);
    colorChooserPanel.setBackground(dts.getCurrentColor());
    repaint();
}//GEN-LAST:event_colorChooserPanelMouseClicked

private void isFilledRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isFilledRadioButtonActionPerformed
    DrawingToolStatus.getInstance().setCurrentIsFilled(
            isFilledRadioButton.isSelected());
    repaint();
}//GEN-LAST:event_isFilledRadioButtonActionPerformed

private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
    DrawingToolStatus.getInstance().removeLastShape();
    repaint();
}//GEN-LAST:event_undoButtonActionPerformed

private void canvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseDragged
    DrawingToolStatus.getInstance().getCurrentTool().performAction(
            evt.getPoint());
    repaint();
}//GEN-LAST:event_canvasMouseDragged

private void canvasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseReleased
    DrawingToolStatus.getInstance().getCurrentTool().mouseReleased();
    repaint();
}//GEN-LAST:event_canvasMouseReleased

private void canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMousePressed
    DrawingToolStatus.getInstance().getCurrentTool().performAction(
            evt.getPoint());
    repaint();
}//GEN-LAST:event_canvasMousePressed

    @Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    DrawingToolStatus dts = DrawingToolStatus.getInstance();
    
    canvas.repaint();
         
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel colorChooserPanel;
    private javax.swing.JRadioButton isFilledRadioButton;
    private javax.swing.JSlider lineWidthSlider;
    private javax.swing.JComboBox toolSelectorComboBox;
    private javax.swing.JLabel toolSelectorLabel;
    private javax.swing.JPanel toolSelectorPanel;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
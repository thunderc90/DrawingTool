    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.gui;

import buckley.DrawingTool.enums.ToolType;
import buckley.DrawingTool.interfaces.ShapeInterface;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author ThunderC
 */
public class DrawingToolCanvas extends Canvas {
    
    private Image buffer;
    private DrawingToolStatus dts;
    
    
    @Override
    public void paint (Graphics g) {
        dts = DrawingToolStatus.getInstance(); 
        Graphics2D gc = (Graphics2D) g;
        Dimension d = this.getSize();
        //refresh previously drawn shapes
        
        if(dts.useBuffer()) {
            //draw all shapes then add to buffer if necessary
                       
            if(dts.buildBuffer() || buffer == null){
                buffer = new BufferedImage(d.width, d.height, BufferedImage.TYPE_4BYTE_ABGR);
                refreshShapes((Graphics2D)buffer.getGraphics());
                dts.bufferRebuilt();
            }
            
            if(dts.addLastToBuffer()) {
                addLastToBuffer();
            }
            
            //draw buffer to screen
            g.drawImage(buffer, 0, 0, this);
            
        } else {
            refreshShapes(gc);
        }
        
        
        if(!dts.isUsingXor()){
            if(dts.getCurrentToolType() == ToolType.SHAPE_MAKER_TOOL
                    || dts.getCurrentToolType() == ToolType.SHAPE_MAKER_TOOL_FILLABLE){
                
                ShapeInterface shape = ((ShapeMaker)dts.getCurrentTool()).getCurrentShape();
                
                if(shape != null && shape.isDrawable()) {
                    shape.draw(gc);
                }
            }
        }
        
        dts.canvasRedrawn();
    }
    
    private void refreshShapes(Graphics2D gc) {
        for(ShapeInterface s : dts.getShapes()) {
            s.draw(gc);
        }
    }
    
    private void addLastToBuffer() {
        if(buffer != null){
            Graphics2D bufg = (Graphics2D)buffer.getGraphics();
            if(!dts.getShapes().isEmpty()) {
                dts.getShapes().get(dts.getShapes().size()-1).draw(bufg);
            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.gui;

import buckley.DrawingTool.enums.ToolType;
import buckley.DrawingTool.interfaces.ShapeInterface;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author ThunderC
 */
public class DrawingToolCanvas extends Canvas {
    
    @Override
    public void paint (Graphics g) {
        DrawingToolStatus dts = DrawingToolStatus.getInstance(); 
        
        //refresh previously drawn shapes
        ArrayList<ShapeInterface> shapes = dts.getShapes();
        Graphics gc = getGraphics();
        for(ShapeInterface s : shapes) {
            s.draw((Graphics2D)gc);
        }
        
        //draw current shape if applicable
        if(dts.getCurrentToolType() == ToolType.SHAPE_MAKER_TOOL 
               || dts.getCurrentToolType() == ToolType.SHAPE_MAKER_TOOL_FILLABLE)
        {
            ((ShapeMaker)dts.getCurrentTool()).draw((Graphics2D)gc);
        }
        
        //TODO:add image storage for increased performance
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.gui.ShapeMaker;
import buckley.DrawingTool.interfaces.ShapeInterface;
import buckley.DrawingTool.enums.ToolType;
import java.awt.Graphics2D;
import java.awt.Point;


/**
 *
 * @author Thunder
 */
public class FreeLineShapeMaker extends ShapeMaker {

    @Override
    protected ShapeInterface initializeNewShape() {
        return new FreeLineShape();
    }

    @Override
    public ToolType getToolType() {
        return ToolType.SHAPE_MAKER_TOOL;
    }
    
    @Override
    public String toString() {
        return "Pen Tool";
    }

       
}

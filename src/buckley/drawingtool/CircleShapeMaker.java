/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.enums.ToolType;
import buckley.DrawingTool.gui.ShapeMaker;
import buckley.DrawingTool.interfaces.ShapeInterface;

/**
 *
 * @author Thunder
 */
public class CircleShapeMaker extends ShapeMaker {

    @Override
    protected ShapeInterface initializeNewShape() {
        return new CircleShape();
    }

    @Override
    public ToolType getToolType() {
        return ToolType.SHAPE_MAKER_TOOL_FILLABLE;
    }
    
    public String toString() {
        return "Circle Tool";
    }
    
}

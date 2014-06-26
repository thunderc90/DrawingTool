/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.enums.ToolType;
import buckley.DrawingTool.gui.DrawingToolStatus;
import buckley.DrawingTool.interfaces.ShapeInterface;
import buckley.DrawingTool.interfaces.Tool;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public class DeleteTool implements Tool{

    @Override
    public void performAction(Point p1, Graphics2D g) {
        
        
        ArrayList <ShapeInterface> affectedShapes = new ArrayList<ShapeInterface>();
        
        
        DrawingToolStatus dts = DrawingToolStatus.getInstance();
        ArrayList<ShapeInterface> shapes = dts.getShapes();

        //hit testing to determine shapes to delete:
        for (int i = shapes.size()-1; i >= 0; i--) {
            if(shapes.get(i).applyManipulator(p1)) {
                affectedShapes.add(shapes.get(i));
            }
        }
        
        //Delete shapes based on deletion strategy
        switch(dts.getCurrentDeleteType()) {
            case DELETE_ALL:
                dts.removeManyShapes(affectedShapes);
                break;
            case DELETE_TOP:
                if(affectedShapes.size() > 0)
                    dts.removeAShape(affectedShapes.get(0));
                break;
        }
        
        dts.buildBuffer();
        dts.redrawCanvas();
        
    }

    @Override
    public void mouseReleased(Graphics2D gc) {
        //do nothing
    }

    @Override
    public ToolType getToolType() {
        return ToolType.MANIPULATOR_TOOL;
    }
    
    @Override
    public String toString() {
        return "Delete Tool";
    }
    
}

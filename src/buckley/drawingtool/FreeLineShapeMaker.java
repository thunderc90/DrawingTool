/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import java.awt.Point;

/**
 *
 * @author Thunder
 */
public class FreeLineShapeMaker extends ShapeMaker {

    @Override
    Shape initializeNewShape() {
        return new FreeLineShape();
    }   
    
    @Override
    public String toString(){
        return "Free Draw Tool";
    }

    @Override
    public ToolTypeEnum getToolType() {
        return ToolTypeEnum.SHAPE_MAKER;
    }
    
}

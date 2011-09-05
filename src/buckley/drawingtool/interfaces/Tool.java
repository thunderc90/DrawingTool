/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.interfaces;

import buckley.DrawingTool.enums.ToolType;
import java.awt.Point;

/**
 *
 * @author Thunder
 */
public interface Tool {
    
    
    public void performAction(Point p1);
    public void mouseReleased();
    public ToolType getToolType();
}

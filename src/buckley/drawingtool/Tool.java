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
public interface Tool {
    
    
    public void performAction(Point p1, Point p2);
    public void mouseReleased();
    public ToolTypeEnum getToolType();
}

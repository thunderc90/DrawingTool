/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Thunder
 */
public interface ShapeInterface {    
    public void update(Point p1, Color c,
            boolean isFilled, int lineWidth);
    public void draw(Graphics2D g);
    public boolean applyManipulator(Point p1);
}

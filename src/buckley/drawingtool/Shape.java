/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Thunder
 */
public interface Shape {    
    public void update(Point p1, Point p2);
    public void draw(Graphics g);
}

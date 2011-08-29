/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public class FreeLineShape implements Shape {
    
    private ArrayList<Point> points;
    
    public FreeLineShape(){
        points = new ArrayList<Point>();
    }

    @Override
    public void update(Point p1, Point p2) {
        //only if no points have been added, add both points.
        // otherwise only add new point
        if(!p1.equals(p2))
        {
            if (points.isEmpty()) {
                points.add(p1);
                points.add(p2);
            } else {
                //sanity check, p1 should original point
                if(p1.equals(points.get(0)))
                    points.add(p2);
                else 
                    System.err.println("ERROR: original point changed!!!");
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        if(!points.isEmpty()) {
            for(int i = 1; i < points.size(); i++) {
                g.drawLine(points.get(i-1).x, 
                        points.get(i-1).y, 
                        points.get(i).x,
                        points.get(i).y);
            }
        }
    }
}

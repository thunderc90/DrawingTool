/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.enums.ShapeType;
import buckley.DrawingTool.gui.DrawingToolStatus;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public class PenShape extends DrawingToolShape {
    private ArrayList<Point> points;
    
    public PenShape() {
        points = new ArrayList<Point>();
    }
    
    @Override
    public ShapeType getShapeType() {
        return ShapeType.REG_SHAPE;
    }

    @Override
    public Shape buildShape() {
        return new GeneralPath();
    }

    @Override
    public void updateShape(Point p1) {
        points.add(p1);
        
        if(points.size() == 1) {
            ((GeneralPath) shape).moveTo(p1.x, p1.y);
        } else {
            ((GeneralPath) shape).lineTo(p1.x, p1.y);
        }
        
    }

    @Override
    public boolean applyManipulator(Point p3) {
        boolean ret = false;
        
        DrawingToolStatus dts = DrawingToolStatus.getInstance();
        
        switch(dts.getCurrentLineHitTestingType()){
            case HIT_TESTING_END_POINTS:
                
                if(points.size() > 0) {
                    if(points.get(0).distance(p3) < (CLOSE_ENOUGH+getLineWidth())/2.0) {
                        ret = true;
                    } else if (points.get(points.size()-1).distance(p3) < (CLOSE_ENOUGH+getLineWidth())/2.0) {
                        ret = true;
                    }
                }
                break;
            case HIT_TESTING_ALONG:
                
                Point p1;
                Point p2;
                
                for (int i = points.size()-1; i > 0 && !ret; i--) {
                    p1 = points.get(i);
                    p2 = points.get(i-1);
                    Point p = new Point();
                    
                    double r = ((p3.x - p1.x) * (p2.x - p1.x) 
                            + (p3.y - p1.y) * (p2.y - p1.y))
                            /(Math.pow(p1.distance(p2), 2));

                    //deal with special conditions
                    if(r <= 0) {
                        p = p1;
                    } else if (r >= 1) {
                        p = p2;
                    } else {
                        p.x = (int ) (p1.x + r * (p2.x - p1.x));
                        p.y = (int ) (p1.y + r * (p2.y - p1.y));
                    }

                    //check distance against close_enough mark
                    if(p.distance(p3) < (CLOSE_ENOUGH + getLineWidth())/2.0) {
                        ret = true;
                    }
                }
                break;
        }
        
        
        return ret;
    }

    @Override
    public boolean isDrawable() {
        return (points.size() >= 2);
          
        
    }
    
    

    
}

    
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.enums.ShapeType;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Thunder
 */
public class CircleShape extends DrawingToolShape {

    private Point p1, p2;
    
    public CircleShape() {
        p1 = null;
        p2 = null;
    }
    
    @Override
    public ShapeType getShapeType() {
        return ShapeType.FILLABLE_SHAPE;
    }

    @Override
    public Shape buildShape() {
        return new Ellipse2D.Double();
    }

    @Override
    public void updateShape(Point newp) {
        if (this.p1 == null) {
           this.p1 = newp; 
        } else {
            this.p2 = newp;
            
            double cx= ((p1.x + p2.x) / 2.0);
            double cy= ((p1.y + p2.y) / 2.0);
            double rad = p1.distance(cx, cy);
            ((Ellipse2D.Double)shape).setFrameFromCenter(
                    cx,
                    cy, 
                    cx + rad, 
                    cy + rad);
        }
        
    }

    @Override
    public boolean applyManipulator(Point p1) {
        boolean ret = false;
        if(isFilled) {
            ret = shape.contains(p1);
        } else {
            Ellipse2D.Double circle = (Ellipse2D.Double) shape;
            Point center = new Point(
                    (int) circle.getCenterX(),
                    (int) circle.getCenterY());
            double dist = center.distance(p1);
            double radius = circle.getWidth()/2.0;
            if(dist < radius + (CLOSE_ENOUGH+getLineWidth())/2.0 
                    && dist > radius - (CLOSE_ENOUGH+getLineWidth())/2.0)
                ret = true;
        }
        
        return ret;
    }
    
    @Override
    public boolean isDrawable() {
        return (p1 != null && p2 != null);
    }
    
}

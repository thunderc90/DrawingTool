/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.enums.ShapeType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public class FreeLineShape extends DrawingToolShape {
    
    ArrayList<Point> points;

    public FreeLineShape() {
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
            ((GeneralPath) shape).moveTo(points.get(0).x, points.get(0).y);
        } else if (points.size() > 1) {
            ((GeneralPath) shape).lineTo(points.get(points.size()-1).x, 
                    points.get(points.size()-1).y);
        }
        
    }

    @Override
    public boolean applyManipulator(Point p1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}

    
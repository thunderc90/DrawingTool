/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.enums.ShapeType;
import buckley.DrawingTool.interfaces.ShapeInterface;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 *
 * @author Thunder
 */
public abstract class DrawingToolShape implements ShapeInterface{
    protected Shape shape;
    private BasicStroke stroke;
    private Color color;
    private boolean isFilled;
    private static final int CLOSE_ENOUGH = 10;
    
    
    @Override
    public void update(Point p1, Color c, boolean isFilled, int lineWidth){
       color = c;
       this.isFilled = isFilled; 
       this.stroke = new BasicStroke((float)lineWidth);
       
       if(shape == null) {
           shape = buildShape();
       }
       
       updateShape(p1);
    }
    
    public void draw(Graphics2D g) {
        //apply setting to graphics object
        g.setStroke(stroke);
        g.setColor(color);
        
        drawShape(g);
    }
    
    public void drawShape(Graphics2D g) {
        if(isFilled && getShapeType() == ShapeType.FILLABLE_SHAPE)
        {
            g.fill(shape);
        } else {
            g.draw(shape);
        }
    }
    
    public abstract ShapeType getShapeType();
    public abstract Shape buildShape();
    public abstract void updateShape(Point p1);
}

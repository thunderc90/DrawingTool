/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import buckley.DrawingTool.DrawingTool;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Abstract definition of a class responsible for building a shape object.
 * @author Thunder
 */
public abstract class ShapeMaker implements Tool, Shape {

    //shape that is currently under construction
    private Shape currentShape;
    
    @Override
    public void performAction(Point p1, Point p2) {
        
        //initialize shape if its not initialized
        if(currentShape == null)
            currentShape = initializeNewShape();
        
        //update shape if initialize shape was successfull
        if(currentShape != null)
            currentShape.update(p1, p2);
        else
            System.err.println("ERROR: Shape failed to initialize");
            
    }
    
    @Override
    public void update(Point p1, Point p2) {
        throw new UnsupportedOperationException("Should not be used "
                + "on ShapeMaker variant of shape");
    }

    @Override
    public void draw(Graphics g) {
        if(currentShape != null)
            currentShape.draw(g);
    }
    
    @Override
    public void mouseReleased() {
        DrawingToolStatus.getInstance().getShapes().add(currentShape);
        currentShape = null;
    }
    
    abstract Shape initializeNewShape();
        
}

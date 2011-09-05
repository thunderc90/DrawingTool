/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.gui;


import buckley.DrawingTool.gui.DrawingToolStatus;
import buckley.DrawingTool.interfaces.Tool;
import buckley.DrawingTool.interfaces.ShapeInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Abstract definition of a class responsible for building a shape object.
 * @author Thunder
 */
public abstract class ShapeMaker implements Tool, ShapeInterface {

    //shape that is currently under construction
    private ShapeInterface currentShape;
    
    @Override
    public void performAction(Point p1) {
        DrawingToolStatus dts = DrawingToolStatus.getInstance();
        
        //initialize shape if its not initialized
        if(currentShape == null)
            currentShape = initializeNewShape();
        
        //update shape if initialize shape was successfull
        if(currentShape != null)
            currentShape.update(p1, dts.getCurrentColor(), dts.getCurrentIsFilled(), dts.getCurrentLineWidth());
        else
            System.err.println("ERROR: Shape failed to initialize");
            
    }
    
    @Override
    public boolean applyManipulator(Point p) {
        throw new UnsupportedOperationException("Should not be used "
                + "on ShapeMaker variant of shape");
    }

    @Override
    public void draw(Graphics2D g) {
        if(currentShape != null)
            currentShape.draw(g);
    }
    
    @Override
    public void mouseReleased() {
        DrawingToolStatus.getInstance().addShape(currentShape);
        currentShape = null;
    }
    
    @Override
    public void update(Point p1, Color c, 
            boolean isFilled, int lineWidth) {
        throw new UnsupportedOperationException("Should not be used "
                + "on ShapeMaker variant of shape");
    }
    
    protected abstract ShapeInterface initializeNewShape();
        
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.gui;

import buckley.DrawingTool.FreeLineShapeMaker;
import buckley.DrawingTool.interfaces.Tool;
import buckley.DrawingTool.interfaces.ShapeInterface;
import buckley.DrawingTool.enums.ToolType;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public class DrawingToolStatus {
    private static DrawingToolStatus _instance;
    
    private ArrayList<ShapeInterface> shapesList;
    
    private Tool currentTool;
    private ToolType currentToolType;
    private Color currentColor;
    private boolean currentIsFilled;
    private int currentLineWidth;
    private ArrayList<Tool> toolList;
    
    static DrawingToolStatus getInstance(){
        if(_instance == null) {
            _instance = new DrawingToolStatus();
        }
        return _instance;
    }
    
    private DrawingToolStatus() {
        currentColor = new Color(255, 102, 0);
        currentIsFilled = false;
        shapesList = new ArrayList<ShapeInterface>();
        
        //initialize toolList
        toolList = new ArrayList<Tool>();
        toolList.add(new FreeLineShapeMaker());
        
        setCurrentTool(toolList.get(0));
        
    }

    void setCurrentTool(Tool t) {
        if(t != null) {
            currentTool = t;
            currentToolType = t.getToolType();
        }
            
    }

    Color getCurrentColor() {
        return currentColor;
    }

    void setCurrentColor(Color newColor) {
        if(currentColor != null)
            currentColor = newColor;
    }

    void setCurrentIsFilled(boolean selected) {
        currentIsFilled = selected;
    }

    Tool getCurrentTool() {
        return currentTool;
    }

    ToolType getCurrentToolType() {
        return currentToolType;
    }

    ArrayList<ShapeInterface> getShapes() {
        return shapesList;
    }
    
    Tool[] getToolList() {
        Tool[] t = new Tool[toolList.size()];
        return  toolList.toArray(t);
    }

    void removeLastShape() {
        if(!shapesList.isEmpty())
            shapesList.remove(shapesList.size()-1);
    }
    
    void clearShapes() {
        if(!shapesList.isEmpty())
            shapesList = new ArrayList<ShapeInterface>();
    }
    
    void addShape(ShapeInterface s) {
        if(s != null) {
            shapesList.add(s);
        }
    }
    
    boolean getCurrentIsFilled() {
        return currentIsFilled;
    }
    
    int getCurrentLineWidth() {
        return currentLineWidth;
    }
    
    void setCurrentLineWidth(int newWidth) {
        currentLineWidth = newWidth;
    }
 }


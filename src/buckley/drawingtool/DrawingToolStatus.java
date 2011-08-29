/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public class DrawingToolStatus {
    private static DrawingToolStatus _instance;
    
    private ArrayList<Shape> shapesList;
    
    private Tool currentTool;
    private ToolTypeEnum currentToolType;
    private Color currentColor;
    private boolean currentIsFilled;
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
        shapesList = new ArrayList<Shape>();
        
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

    ToolTypeEnum getCurrentToolType() {
        return currentToolType;
    }

    ArrayList<Shape> getShapes() {
        return shapesList;
    }
    
    Tool[] getToolList() {
        Tool[] t = new Tool[toolList.size()];
        return  toolList.toArray(t);
    }

    void Undo() {
        shapesList.remove(shapesList.size()-1);
    }
 }

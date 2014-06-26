/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.gui;

import buckley.DrawingTool.CircleShapeMaker;
import buckley.DrawingTool.DeleteTool;
import buckley.DrawingTool.PenShapeMaker;
import buckley.DrawingTool.enums.DeleteType;
import buckley.DrawingTool.enums.LineHitTestingType;
import buckley.DrawingTool.interfaces.Tool;
import buckley.DrawingTool.interfaces.ShapeInterface;
import buckley.DrawingTool.enums.ToolType;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public final class DrawingToolStatus {
    private static DrawingToolStatus _instance;
    
    private ArrayList<ShapeInterface> shapesList;
    
    private Tool currentTool;
    private ToolType currentToolType;
    private Color currentColor;
    private boolean currentIsFilled;
    private int currentLineWidth;
    private ArrayList<Tool> toolList;
    private DeleteType deleteType; 
    private LineHitTestingType lineHTType;
    private boolean redrawCanvas;
    private boolean xor;
    private boolean useBuffer;
    private boolean buildBuffer;
    private boolean addLastToBuffer;
   
    
    private DrawingToolStatus() {
        currentColor = new Color(255, 102, 0);
        currentIsFilled = false;
        shapesList = new ArrayList<ShapeInterface>();
        currentLineWidth = 2;
        deleteType = DeleteType.DELETE_ALL;
        lineHTType = LineHitTestingType.HIT_TESTING_ALONG;
        xor = true;
        useBuffer = true;
        buildBuffer = false;
        addLastToBuffer = false;
        
        //initialize toolList
        toolList = new ArrayList<Tool>();
        toolList.add(new PenShapeMaker());
        toolList.add(new CircleShapeMaker());
        toolList.add(new DeleteTool());
        
        setCurrentTool(toolList.get(0));
        
    }
    
    public void canvasRedrawn() {
        redrawCanvas = false;
    }
    
    public void bufferRebuilt() {
        buildBuffer = false;
    }
    
    //-------------SHAPELIST MODIFIERS---------------
    
    public void clearShapes() {
        if(!shapesList.isEmpty()) {
            shapesList = new ArrayList<ShapeInterface>();
            setRedrawCanvas();
        }
    }
    
    public void addShape(ShapeInterface s) {
        if(s != null) {
            shapesList.add(s);
            setRedrawCanvas();
            setBuildBuffer();
        }
    }
    
    public void removeLastShape() {
        if(!shapesList.isEmpty()){
            shapesList.remove(shapesList.size()-1);
            setRedrawCanvas();
            setBuildBuffer();
        }
    }
    
    public void removeManyShapes(ArrayList<ShapeInterface> removeus) {
        if(removeus !=null && removeus.size()>0){
           if(shapesList.removeAll(removeus)){
               setRedrawCanvas();
               setBuildBuffer();
           }
        }
    }
    
    public void removeAShape(ShapeInterface removeme) {
        if(removeme != null) {
            if(shapesList.remove(removeme)){
                setRedrawCanvas();
                setBuildBuffer();
            }
        }
    }

    
    //------------SETTERS------------------
    void setCurrentTool(Tool t) {
        if(t != null) {
            currentTool = t;
            currentToolType = t.getToolType();
        }
            
    }
    
    void setCurrentColor(Color newColor) {
        if(currentColor != null)
            currentColor = newColor;
    }

    void setCurrentIsFilled(boolean selected) {
        currentIsFilled = selected;
    }
    
    void setCurrentLineWidth(int newWidth) {
        currentLineWidth = newWidth;
    }

    void setCurrentDeleteType(DeleteType newDeleteType) {
        deleteType = newDeleteType;
    }
    
    void setCurrentLineHitTestingType(LineHitTestingType newTestingType) {
        lineHTType = newTestingType;
    }
    
    void setRedrawCanvas() {
        redrawCanvas = true;
    }
    
    void useXor(boolean isUsingXor) {
        xor = isUsingXor;
    }
     
    public void setBuildBuffer() {
        buildBuffer = true;
    }
    
    public void setUseBuffer(boolean useBuffer) {
        this.useBuffer = useBuffer;
    }

    
    public void setAddLastToBuffer() {
        addLastToBuffer = true;
    }
    
    //--------------GETTERS----------------
    Color getCurrentColor() {
        return currentColor;
    }

    public static DrawingToolStatus getInstance(){
        if(_instance == null) {
            _instance = new DrawingToolStatus();
        }
        return _instance;
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    ToolType getCurrentToolType() {
        return currentToolType;
    }

    public ArrayList<ShapeInterface> getShapes() {
        return shapesList;
    }
    
    Tool[] getToolList() {
        Tool[] t = new Tool[toolList.size()];
        return  toolList.toArray(t);
    }

    boolean getCurrentIsFilled() {
        return currentIsFilled;
    }
    
    int getCurrentLineWidth() {
        return currentLineWidth;
    }   
    
    public DeleteType getCurrentDeleteType() {
        return deleteType;
    }
    
    public LineHitTestingType getCurrentLineHitTestingType() {
        return lineHTType;
    }
    
    public boolean redrawCanvas() {
        return redrawCanvas;
    }
    
    public boolean isUsingXor() {
        return xor;
    }
       
    public boolean buildBuffer() {
        return buildBuffer;
    }
    
    public boolean useBuffer() {
        return useBuffer;
    }
    
    public boolean addLastToBuffer() {
        return addLastToBuffer;
    }
 }


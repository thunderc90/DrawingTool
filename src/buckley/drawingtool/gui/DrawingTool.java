/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buckley.DrawingTool.gui;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Thunder
 */
public class DrawingTool {
    
    public static void main(){
        //when running from main, use default JFrame Mode...
        new DrawingTool();
    }
    
        
    public DrawingTool() {   
        
        initializeGui();
    }
    
    private void initializeGui() {
        //initialize status object before initializing frame
        new DrawingToolFrame();
    }
    
}

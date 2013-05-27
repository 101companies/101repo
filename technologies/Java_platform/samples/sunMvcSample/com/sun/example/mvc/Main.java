/*
 * Main.java
 *
 * Created on January 10, 2007, 1:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.sun.example.mvc;

import com.sun.example.mvc.controller.DefaultController;
import com.sun.example.mvc.model.DocumentModel;
import com.sun.example.mvc.view.DisplayViewPanel;
import com.sun.example.mvc.view.PropertiesViewPanel;
import com.sun.example.mvc.model.TextElementModel;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Robert Eckstein
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
        
    	// Create models
        TextElementModel textElementModel = new TextElementModel();
        DocumentModel documentModel = new DocumentModel();

        // Create controller
        DefaultController controller = new DefaultController();
        
        // Create view panels and connect them to controller
        DisplayViewPanel displayViewPanel = new DisplayViewPanel(controller);       
        PropertiesViewPanel propertiesViewPanel = new PropertiesViewPanel(controller);
        
        // Register views and models with controller
        controller.addView(displayViewPanel);
        controller.addView(propertiesViewPanel);
        controller.addModel(textElementModel);
        controller.addModel(documentModel);
        
        // Set up test data for models
        textElementModel.initDefault();
        documentModel.initDefault();        
        
        // Create GUI objects
        JFrame displayFrame = new JFrame("Display (View 1)");
        displayFrame.getContentPane().add(displayViewPanel, BorderLayout.CENTER);
        displayFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        displayFrame.pack();
        
        JDialog propertiesDialog = new JDialog(displayFrame, "Properties (View 2)");
        propertiesDialog.setModal(false);
        propertiesDialog.getContentPane().add(propertiesViewPanel, BorderLayout.CENTER);
        propertiesDialog.pack();
        
        // Show GUI objects
        displayFrame.setVisible(true);
        propertiesDialog.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}

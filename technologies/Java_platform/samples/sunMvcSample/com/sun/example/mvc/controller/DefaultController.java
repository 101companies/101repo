/*
 * DefaultController.java
 *
 * Created on January 22, 2007, 8:42 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.sun.example.mvc.controller;

import java.awt.Font;

/**
 * This controller implements the required methods and provides the properties
 * necessary to work with the DisplayViewPanel and PropertyViewPanel views. Each of
 * methods in this class can be called upon by the views to update to state of the
 * registered models.
 *
 * @author Robert Eckstein
 */
public class DefaultController extends AbstractController
{

    //  Properties this controller expects to be stored in one or more registered models
    
    /**
     * The document's name
     */
    public static final String DOCUMENT_NAME_PROPERTY = "Name";
    /**
     * The document's width
     */
    public static final String DOCUMENT_WIDTH_PROPERTY = "Width";
    /**
     * The document's height
     */
    public static final String DOCUMENT_HEIGHT_PROPERTY = "Height";    
    /**
     * The text element's string
     */
    public static final String ELEMENT_TEXT_PROPERTY = "Text";
    /**
     * The text element's font
     */
    public static final String ELEMENT_FONT_PROPERTY = "Font";
    /**
     * The text element's X position
     */
    public static final String ELEMENT_X_PROPERTY = "X";
    /**
     * The text element's Y position
     */
    public static final String ELEMENT_Y_PROPERTY = "Y";
    /**
     * The text element's opacity
     */
    public static final String ELEMENT_OPACITY_PROPERTY = "Opacity";
    /**
     * The text element's rotation
     */
    public static final String ELEMENT_ROTATION_PROPERTY = "Rotation";
    
    /**
     * Change the document name in the model
     * @param newName The new document name
     */
    public void changeDocumentName(String newName) {
        setModelProperty(DOCUMENT_NAME_PROPERTY, newName);                                 
    }
    
    /**
     * Change the document width in the model
     * @param newWidth The new document width
     */
    public void changeDocumentWidth(int newWidth) {
        setModelProperty(DOCUMENT_WIDTH_PROPERTY, newWidth);                                 
    }
    
    /**
     * Change the document height in the model
     * @param newHeight The new document height
     */
    public void changeDocumentHeight(int newHeight) {
        setModelProperty(DOCUMENT_HEIGHT_PROPERTY, newHeight);                         
    }
    
    
    /**
     * Change the text element string in the model
     * @param newText The new text element string
     */
    public void changeElementText(String newText) {
        setModelProperty(ELEMENT_TEXT_PROPERTY, newText);                 
    }
    
    /**
     * Change the text element font in the model
     * @param newFont The new text element font
     */
    public void changeElementFont(Font newFont) {
        setModelProperty(ELEMENT_FONT_PROPERTY, newFont);
    }
    
    /**
     * Change the text element X position value in the model
     * @param newX The new text element X position
     */
    public void changeElementXPosition(int newX) {
        setModelProperty(ELEMENT_X_PROPERTY, newX);         
    }
    
    /**
     * Change the text element Y position value in the model
     * @param newY The new text element Y position
     */
    public void changeElementYPosition(int newY) {
        setModelProperty(ELEMENT_Y_PROPERTY, newY);        
    }
    
    /**
     * Change the text element opacity value in the model
     * @param newOpacity The new text element opacity value
     */
    public void changeElementOpacity(int newOpacity) {
        setModelProperty(ELEMENT_OPACITY_PROPERTY, newOpacity);
    }
    
    /**
     * Change the text element rotation value in the model
     * @param newRotation The new text element rotation value
     */
    public void changeElementRotation(int newRotation) {
        setModelProperty(ELEMENT_ROTATION_PROPERTY, newRotation);        
    }
    
}

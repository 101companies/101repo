/*
 * DocumentModel.java
 *
 * Created on January 22, 2007, 3:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.sun.example.mvc.model;

import com.sun.example.mvc.controller.DefaultController;

/**
 * A sample class that mimics some properties found in a document, including
 * its name, width, and height.
 *
 * @author Robert Eckstein
 */
public class DocumentModel extends AbstractModel
{
       
    private String name;
    private Integer width;
    private Integer height;
   

    /**
     * Default constructor
     */
    public DocumentModel()
    {   
    }
    
    /**
     * Provides the means to set or reset the model to a default state.
     */
    public void initDefault() {
        
        setName("Sample Document");
        setWidth(500);
        setHeight(500);
        
    }
    
    
    //  Accessors
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        
        String oldName = this.name;
        this.name = name;
        
        firePropertyChange(
        		DefaultController.DOCUMENT_NAME_PROPERTY, oldName, name);
    }


    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        
        Integer oldWidth = this.width;
        this.width = width;
        
        firePropertyChange(DefaultController.DOCUMENT_WIDTH_PROPERTY, oldWidth, width);
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        
        Integer oldHeight = this.height;
        this.height = height;
        
        firePropertyChange(DefaultController.DOCUMENT_HEIGHT_PROPERTY, oldHeight, height);
    } 
  
}
    


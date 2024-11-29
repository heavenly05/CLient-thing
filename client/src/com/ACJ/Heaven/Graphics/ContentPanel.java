package com.ACJ.Heaven.Graphics;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;

public class ContentPanel {
    protected JPanel panel = new JPanel();
    //protected String panelName;


    /**
     * This is a class that Consists of A JPanel which is meant to be scrolled over with A ScrollPanel.
     * 
     * It does so by encapsulating a JPanel.
     */

    ArrayList<Component> componentList = new ArrayList<>();
    
    public ContentPanel(){
        this.panel = new JPanel();
    }
    public ContentPanel(JPanel panel){
        this.panel = panel;
    }

    public int getNumOfAddedComponents(){
        return componentList.size();
    }

    public void addComponent(Component component){
        componentList.add(component);  
        this.panel.add(component);
    }
    public void removeComponent(){
        
    }
        public JPanel getPanel(){
            return panel;
        }

        public void setPanel(JPanel panel) {
            this.panel = panel;
        }
        //public String getPanelName() {
        //    return panelName;
        //}
}

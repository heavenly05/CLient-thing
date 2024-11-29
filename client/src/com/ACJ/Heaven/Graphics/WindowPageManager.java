package com.ACJ.Heaven.Graphics;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;


public class WindowPageManager extends GlobalPageManager{
    Window window;
    GridBagConstraints gbc = new GridBagConstraints();
    Page currentPage = null;
    Page previousPage = null;
    int mainViewPercentage;
    int sideBarPercentage;

    public WindowPageManager(Window window){
        this.window = window;
    }

    protected void initiliazePage(){
        this.window.getNavBar().add(new JLabel(this.getCurrentPage().getTitle()));
        this.setRatios();
        fixTheWindow();
        reloadWindow();
    }

    public void reloadWindow(){
        this.window.jFrame.getContentPane().removeAll();
        this.window.jFrame.revalidate();
        this.window.jFrame.repaint();
        
        addNavBar();
        if((this.currentPage.sideBar == null && this.currentPage.mainView == null)){
            System.out.println("Both panels were removed, readding them both to decrease chance of problems");
            this.resetPanels();
        }else if(this.currentPage.sideBar == null ){
            this.addSingleScrollPanel(this.getCurrentMainView());
        }else if(this.currentPage.mainView == null){
            this.addSingleScrollPanel(this.getCurrentSideBar());
        }else{
            addScrollPanels();
        }
    } 

    

    public void setCurrentPage(Page page){   
        if(this.currentPage == null){
            this.previousPage = page;
            this.currentPage = page;
            //this means this is the first page added
        }else{
            this.currentPage.onPageSwitch();
            this.previousPage = currentPage;
            this.currentPage = page;
            this.onPageSwitch();
            //this means this is not the first page added
        }
        initiliazePage();
    }

    public void removeScrollPanel(int constant){
        // 0 = sideBar 1 = Mainview
        switch (constant) {
            case 0 -> this.currentPage.setMainView(null);
            case 1 -> this.currentPage.setSideBar(null);
            default -> System.err.println("Constant not recognized");
        }
        this.reloadWindow();
    }


    public Page getCurrentPage(){
        return this.currentPage;
    }
    public Page getPreviousPage(){
        return this.previousPage;
    }
    public ScrollPanel getCurrentSideBar() {
        return this.currentPage.getSideBar();
    }

    public ScrollPanel getCurrentMainView() {
        return this.currentPage.getMainView();
    }

    private void setRatios(){

        /*if((this.currentPage.sideBar == null && this.currentPage.mainView == null)){
            this.resetPanels();
        }else*/ if(this.currentPage.sideBar == null ){
            this.mainViewPercentage = (int)((this.getCurrentMainView().getPanelPercentageWidth() - this.getCurrentPage().getAssignedMainView().getPanelPercentageWidth())* 100);

            this.getCurrentMainView().getScrollPane().setPreferredSize(new Dimension(this.window.percentageOfWindowWidth(this.mainViewPercentage), this.window.jFrame.getHeight()- this.window.getNavBar().getHeight()));
        }else if(this.currentPage.mainView == null){
            this.sideBarPercentage = (int)((this.getCurrentSideBar().getPanelPercentageWidth() / this.getCurrentPage().getAssignedSideBar().getPanelPercentageWidth()) * 100);

            this.getCurrentSideBar().getScrollPane().setPreferredSize(new Dimension(this.window.percentageOfWindowWidth(this.sideBarPercentage), this.window.jFrame.getHeight() - this.window.getNavBar().getHeight()));
        }else{
            this.mainViewPercentage = (int)((this.getCurrentMainView().getPanelPercentageWidth() - this.getCurrentSideBar().getPanelPercentageWidth())* 100);
        
        this.sideBarPercentage = (int)((this.getCurrentSideBar().getPanelPercentageWidth() / this.getCurrentMainView().getPanelPercentageWidth()) * 100);

        
        this.getCurrentMainView().getScrollPane().setPreferredSize(new Dimension(this.window.percentageOfWindowWidth(this.mainViewPercentage), this.window.jFrame.getHeight()- this.window.getNavBar().getHeight()));

        this.getCurrentSideBar().getScrollPane().setPreferredSize(new Dimension(this.window.percentageOfWindowWidth(this.sideBarPercentage), this.window.jFrame.getHeight() - this.window.getNavBar().getHeight()));
        }
        

        
        
    }
    private void addNavBar(){
        //for navbar
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        gbc.weighty = 0.089;
        gbc.fill = GridBagConstraints.BOTH;
        this.window.jFrame.add(this.window.getNavBar(), gbc);
    }

    private void addSingleScrollPanel(ScrollPanel panel){
        //fix up what the navbar messed up
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 0;   
        gbc.gridy = 1;
        gbc.gridwidth = 2;

        this.window.jFrame.add(panel.getScrollPane(), gbc);
    }

    private void addScrollPanels(){
        gbc.weighty = 1.0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        //for sidebar
        
        gbc.gridx = 0;
        gbc.weightx = this.getCurrentSideBar().getPanelPercentageWidth();
        this.window.jFrame.add(this.getCurrentSideBar().getScrollPane(), gbc);
          
        //for mainview
        gbc.gridx = 1;
        gbc.weightx = this.getCurrentMainView().getPanelPercentageWidth();
        this.window.jFrame.add(this.getCurrentMainView().getScrollPane(), gbc);
    }

    /*private void attemptFixPanels(){
        this.getCurrentPage().applyAssignedPanels();
    }*/
    private void fixTheWindow(){
        this.window.jFrame.setSize(this.window.jFrame.getWidth() + 1,this.window.jFrame.getHeight());
        this.window.jFrame.setSize(this.window.jFrame.getWidth() - 1,this.window.jFrame.getHeight());
    }


    private void onPageSwitch(){
        System.out.println("page switched");
        System.out.println("Previous Page: " + this.previousPage.getTitle());
        System.out.println("Current Page: " + this.currentPage.getTitle());
    }
    public void resetPanels(){
        this.getCurrentPage().applyAssignedPanels();
        this.reloadWindow();
    }
    public final static class ScrollPanelConstants{
        public static final int SIDEBAR = 0x1;
        public static final int MAINVIEW = 0x0;
    }
}

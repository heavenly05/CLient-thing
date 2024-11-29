package com.ACJ.Heaven.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("OverridableMethodCallInConstructor")
public abstract class Page {
    protected final ScrollPanel AssignedSideBar;
    protected final ScrollPanel AssignedMainView;
    protected String title = "Page";
    protected ScrollPanel sideBar;
    protected ScrollPanel mainView;

    /**
     * A container for a sidebar and mainScrollable. Both sdebar and mainScrollable
     * are A scrollpanel which encapsulate a JScrollPane and a Content Panel which
     * encapsulates a JPanel.
     */

    public Page() {
        // start off completely blank with the scroll panel dimensions set to 50 - 50
        this.setSideBar(new ScrollPanel());
        this.setMainView(new ScrollPanel());
        this.AssignedMainView = this.getMainView();
        this.AssignedSideBar = this.getSideBar();
        lastMinuteChanges();
        
    }


    public Page(double sideBarWeight, double mainViewWeight) {
        // start off blank with custom size for each panel
        System.out.println("With percentages, no Scrollables");
        
        this.setSideBar(new ScrollPanel(sideBarWeight));
        this.setMainView(new ScrollPanel(mainViewWeight));
        this.AssignedMainView = this.getMainView();
        this.AssignedSideBar = this.getSideBar();

        lastMinuteChanges();
    }

    /**
     * A container that encapsulates the ScrollPanel And ContentPanel Class into one
     * object, much like an HTML page.
     * 
     * @param sideBar
     * @param MainScrollable
     */
    public Page(ScrollPanel sideBar, ScrollPanel mainView) {
        // start off with set Scrollpanels
        System.out.println("With Scrollables, optional percentages");
        this.AssignedMainView = mainView;
        this.AssignedSideBar = sideBar;
        this.setSideBar(sideBar);
        this.setMainView(mainView);
        lastMinuteChanges();
    }

    public ScrollPanel getMainView() {
        return this.mainView;
    }

    public ContentPanel getMainViewContent() {
        return this.getMainView().getContentPanel();
    }

    public JPanel getMainViewJPanel() {
        return this.getMainView().getContentPanel().getPanel();
    }

    public void setMainView(ScrollPanel mainView) {
        this.mainView = mainView;
    }

    public void setMainViewContent(ContentPanel mainViewContent) {
        this.mainView.setContentPanel(mainViewContent);
    }

    public void setMainViewJPanel(JPanel panel) {
        this.mainView.getContentPanel().setPanel(panel);
    }

    public ScrollPanel getAssignedSideBar(){
        return this.AssignedSideBar;
    }

    public ScrollPanel getAssignedMainView(){
        return this.AssignedMainView;
    }

    public JPanel getSideBarJPanel() {
        return this.sideBar.getContentPanel().getPanel();
    }

    public ScrollPanel getSideBar() {
        return this.sideBar;
    }

    public ContentPanel getSideBarContent() {
        return this.sideBar.getContentPanel();
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setSideBar(ScrollPanel sidebar) {
        this.sideBar = sidebar;
        //AppWindowManager.getCurrentWindow().reloadWindow();
    }

    public void setSideBarJPanel(JPanel panel) {
        this.getSideBar().getContentPanel().setPanel(panel);
        //AppWindowManager.getCurrentWindow().reloadWindow();
    }

    public void setSideBarContent(ContentPanel sideBarContent) {
        this.getSideBar().setContentPanel(sideBarContent);
        //AppWindowManager.getCurrentWindow().reloadWindow();
    }

    public void applyAssignedPanels(){
        this.setMainView(AssignedMainView);
        this.setSideBar(AssignedSideBar);
    }

    // the first thing that should happen is that the sideBar and MainView ScrollPanels should be
    // created, even if empty they are dynamic and things can be added or changed
    // within them.

    // the second thing that needs to happen is the ContentPanels (JPanels) need to be initilized,
    // the content panels need to be ready for it.

    // the last thing to do is the content panels need to be added to the ScrollPanels. 

    // you can use geniusness to combine step 2 and three

    //

    // scrollables, optionally with percentages


    //A REVISION
    //What should actually happen is first off, There are blank ScrollPanels for the sidebar and mainview already.

    //since we already have the scrollpanels next all wed have to do is create a content panel for them.

    //before we create a content panel we should alreayd have the contents initilized.

    //after that we can set the contents of the scroll panels.

    //thats for if its a blank page



    // set percentages, no scrollables
    /*protected void initiliazePage(int sidebarW, int mainContentW) {

        // Set side the side bar contents of the scrollable panels
        //what the actual hell is this
        //your setti
        this.setSideBarContent(new ContentPanel(this.getSideBarJPanel()));
        this.setMainViewContent(new ContentPanel(this.getMainViewJPanel()));

        // add the scrollable(s) to the Page
        this.setSideBar(new ScrollPanel(this.getSideBarContent(), sidebarW));
        this.setMainView(new ScrollPanel(this.getMainViewContent(), mainContentW));
    };*/

    // no percentages, no scrollables
    protected void initiliazePage() {
        


        
        // add the scrollable(s) to the Page
    }

    protected abstract void lastMinuteChanges();
    protected abstract void onPageSwitch();
}
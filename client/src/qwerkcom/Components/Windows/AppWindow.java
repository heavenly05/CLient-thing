package qwerkcom.Components.Windows;

import com.ACJ.Heaven.Graphics.Window;
import com.ACJ.Heaven.Graphics.WindowPageManager;

import java.awt.*;
import javax.swing.*;

public class AppWindow extends Window{

    private WindowPageManager pageManager = new WindowPageManager(this);

    JMenuBar navBar;

    public AppWindow(String title) {
        super(title);
    }
    public AppWindow(String title, String iconFilePath){
        super(title, iconFilePath);
    }
    public AppWindow(String title, String iconFilePath, int wPercentage, int hPercentage){
        super(title, wPercentage, hPercentage);
    }
    public AppWindow(String title, int wPercentage, int hPercentage){
        super(title, wPercentage, hPercentage);
    }

    @Override

    protected void startup() throws Exception{
        //things to do before the window initilizes
        System.out.println("Window Dimension: " + windowDimension);
        //create and set the properties of components here
        this.navBar = new JMenuBar();
        this.navBar.setBackground(Color.green);
        
        //this.pageManager.removeScrollPanel(0);
    }
    
    @Override
    protected void beforeVisible() {
        //things to do right before JFrame becomes visible.

        //set the sizes of the components here
        this.pageManager.setCurrentPage(WindowPageManager.getHomePage());
        
    }



    @Override
    protected void afterVisible() {

    }

    @Override
    protected void work() {
        //things to do after initilization
         System.out.println("Window running");
         
    }




    //COMPONENT METHODS
    @Override
    public JMenuBar getNavBar() {
        return this.navBar;
    }
    
    public void setNavBar(JMenuBar navBar) {
        this.navBar = navBar;
    }




    @Override
    protected void onResize(){
        
    }

    
    public WindowPageManager getPageManager() {
        return this.pageManager;
    }

    public void setWindowPageManager(WindowPageManager pageManager) {
        this.pageManager = pageManager;
    }
}

package qwerkcom.Components.Pages;

import com.ACJ.Heaven.Graphics.Page;

import qwerkcom.Components.PageScrollPanels;

import java.awt.Color;

import javax.swing.BorderFactory;

public final class Homepage extends Page{

    public Homepage(){
        super(PageScrollPanels.getHomePageSideBar(), PageScrollPanels.getHomePageMainView());
        setTitle("Homepage");
    }


    @Override
    protected void lastMinuteChanges(){
        this.getMainView().getScrollPane().setBorder(BorderFactory.createLineBorder(Color.black));
    }


    @Override
    protected void onPageSwitch() {
        System.out.println("Homepage out!");
    }


    



    
}

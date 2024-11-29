package qwerkcom.Components.Pages;

import com.ACJ.Heaven.Graphics.Page;

import qwerkcom.Components.PageScrollPanels;


public class SearchPage extends Page{
    public SearchPage(){
        super(PageScrollPanels.getSearchPageSideBar(), null);
        setTitle("Search Page");
    }


    @Override
    protected void lastMinuteChanges(){
        
    }


    @Override
    protected void onPageSwitch() {
        System.out.println("Searchpage out!");
    }
}

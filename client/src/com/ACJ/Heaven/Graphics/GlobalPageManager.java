package com.ACJ.Heaven.Graphics;

import qwerkcom.Components.Pages.Homepage;
import qwerkcom.Components.Pages.SearchPage;

public abstract class GlobalPageManager{
    public static Page getHomePage(){
        return new Homepage();
    }

    public static Page getSearchPage(){
        return new SearchPage();
    }

    
}
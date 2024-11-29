package qwerkcom.Components;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ACJ.Heaven.Graphics.ScrollPanel;
import com.ACJ.Heaven.Graphics.WindowPageManager;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import qwerkcom.AppManager;
import qwerkcom.Components.Windows.AppWindow;

public abstract class PageScrollPanels {
    //the scroll panels will be responsible for initilizing the content panels.
    private static class HomepageSideBar extends ScrollPanel{
        

        public HomepageSideBar() {
            super(0.25);
            JPanel panel = this.getContentPanel().getPanel();
            panel.setLayout(new GridLayout(11,1));
            panel.setBackground(Color.red);
            JButton button = new JButton("go to search page");
            button.addActionListener((ActionEvent e) -> {
                ((AppWindow)AppManager.getWindowManager().getCurrentWindow()).getPageManager().setCurrentPage(WindowPageManager.getSearchPage());
            });
            panel.add(button);
            for (int i = 0; i < 9; i++) {
                JButton buttona = new JButton("Button" + i);

                panel.add(buttona);
            }
            
        }
    }

    private static class HomepageMainView extends ScrollPanel{
        public HomepageMainView() {
            super(1.0);
            JPanel panel = this.getContentPanel().getPanel();
            panel.setBackground(Color.blue);
            
            
        }
    }

    public static ScrollPanel getHomePageSideBar(){
        return new HomepageSideBar();
    }

    public static ScrollPanel getHomePageMainView(){
        return new HomepageMainView();
    }
    





    private static class SearchPageSideBar extends ScrollPanel{
        public SearchPageSideBar() {
            super(1.0);
            JPanel panel = this.getContentPanel().getPanel();
            panel.setLayout(new GridLayout(11,1));
            panel.setBackground(Color.red);
            JButton button = new JButton("go to search page");
            button.addActionListener((ActionEvent e) -> {
                
                ((AppWindow)AppManager.getWindowManager().getCurrentWindow()).getPageManager().setCurrentPage(WindowPageManager.getHomePage());
            });
            panel.add(button);
            for (int i = 0; i < 9; i++) {
                JButton buttona = new JButton("Button" + i);

                panel.add(buttona);
            }
        }
    }

    public static ScrollPanel getSearchPageSideBar(){
        return new SearchPageSideBar();
    }
}

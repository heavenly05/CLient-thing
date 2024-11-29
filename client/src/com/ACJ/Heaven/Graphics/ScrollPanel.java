package com.ACJ.Heaven.Graphics;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("OverridableMethodCallInConstructor")
public class ScrollPanel {

    protected JScrollPane scrollPane = new JScrollPane();
    protected ContentPanel contentPanel;
    protected double PanelWidth = 1.0;
    //protected Dimension windowDimension = AppManager.getWindowManager().getCurrentWindow().windowDimension;
    /**
     * Consists of A Content Panel And ScrollPanel. 
     * 
     * This element acts as a Scrollpanel which contains a content panel which is essentially a jpanel.
     * @param panel
     */
    
    public ScrollPanel(){
        System.out.println("With Nothing");
        initiliaze(new ContentPanel());
    }

    public ScrollPanel(ContentPanel panel, double percentagew){
        this.PanelWidth = percentagew;
        System.out.println("With panel and set dimensions");
        initiliaze(panel);
    }

    public ScrollPanel(double percentagew){
        this.PanelWidth = percentagew;
        System.out.println("Only with set dimensions");
        initiliaze(new ContentPanel());
    }


    public ScrollPanel(ContentPanel panel){
        System.out.println("With Panel but without set dimensions");
       initiliaze(panel);
    }

    protected void initiliaze(ContentPanel panel){
        this.setContentPanel(panel);
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //set the current panel to be the scrollable
        this.scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
        this.scrollPane.setViewportView(this.getContentPanel().getPanel());
    }


    public ContentPanel getContentPanel() {
        return this.contentPanel;
    }
    
    public double getPanelPercentageWidth(){
        return this.PanelWidth;
    }

    public JScrollPane getScrollPane() {
        return this.scrollPane;
    }
    


    public void setContentPanel(ContentPanel contentPanel) {
        this.contentPanel = contentPanel;
        this.scrollPane.setViewportView(contentPanel.getPanel());
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
        
    }
    
}

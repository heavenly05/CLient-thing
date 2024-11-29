package com.ACJ.Heaven.Graphics;

import com.ACJ.Heaven.Utilities.TrashMath.Percentage;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

@SuppressWarnings("OverridableMethodCallInConstructor")
public abstract class Window {
    protected JFrame jFrame = new JFrame();
    protected String imageFilePath;
    protected String title = "";
    protected File imageFile;
    protected Dimension windowDimension;
    protected static final Dimension screenDimension = Display.ScreenDimensions.getScreenDimension();
    protected GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();


    public Window(String title){
        setupCrucials(title, 65, 68);
    }

    public Window(String title, String iconFilePath){
        setupCrucials(title, 65, 68);
    }

    public Window(String title, String iconFilePath, int wPercentage, int hPercentage){
        setupCrucials(title, wPercentage, hPercentage);
    }

    public Window(String title, int wPercentage, int hPercentage){
        setupCrucials(title, wPercentage, hPercentage);
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }


    public void invoke(){
        SwingUtilities.invokeLater(() -> {
            try {
                startup();
                initiliaze(this.title, this.imageFilePath);
                work();
            } catch (Exception ex) {
            }
            });
    }
    
    public void setupCrucials(String title,int widthPercentage, int heightPercentage){
        setTitle(title);
        setWindowDimension(widthPercentage, heightPercentage);
    }
    public void enterFullScreen(){
        jFrame.setUndecorated(true);
        device.setFullScreenWindow(this.jFrame);
    }
    public void exitFullscreen(){
        jFrame.setUndecorated(false);
        device.setFullScreenWindow(null);
        this.jFrame.setVisible(true);
    }
    public Dimension getScreenDimension(){
        return Window.screenDimension;
    }
    public Dimension getWindowDimension(){
        return this.windowDimension;
    }

    public void setWindowDimension(Dimension dimension){
        this.windowDimension = dimension;
        getJFrame().setSize(dimension);
    }

    public JFrame getJFrame(){
        return this.jFrame;
    }

    public void setJFrame(JFrame frame){
        this.jFrame = frame;
    }
    public void setIconImage(String iconPath){
        try {
            this.jFrame.setIconImage(ImageIO.read(new File(iconPath)));
            this.imageFile = new File(iconPath);
            this.imageFilePath = iconPath;
        } catch (IOException e) {
            System.err.println(e.getCause().getMessage());
        }
    }
    public File getIconImageFile(){
        return imageFile;
    }

    public String getIconImagePath(){
        return imageFilePath;
    }
    public static int percentageOfScreenWidth(int percent){
        return (((int)((percent * screenDimension.getWidth()) / 100)));
    }

    public  int percentageOfScreenHeight(int percent){
        return ((int)((percent * screenDimension.getHeight()) / 100));
    }

    public int percentageOfWindowWidth(int percent){
        return (((int)((percent * windowDimension.getWidth()) / 100)));
    }
    public int percentageOfWindowHeight(int percent){
        return (((int)((percent * windowDimension.getHeight()) / 100)));
    }

    protected void initiliaze(String Title, String iconPath){
        try {
            this.jFrame.setTitle(Title);
            this.jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.jFrame.setSize(this.windowDimension);
            this.jFrame.setLocationRelativeTo(null);
            this.jFrame.setMinimumSize(new Dimension(percentageOfScreenWidth(50), percentageOfScreenHeight(65)));
            this.jFrame.setMaximumSize(new Dimension(720,500));
            if(iconPath != null){
                this.setIconImage(iconPath);
            }
            this.imageFilePath = iconPath;
            
            jFrame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    onResize();
                }
            });
            this.jFrame.setLayout(new GridBagLayout());
            
            beforeVisible();
            this.jFrame.pack();
            this.jFrame.setVisible(true);
            afterVisible();
        } catch (Exception e) {
            System.err.println(e.getCause().getMessage());
        }
    }

    /**
     * Method to run before window initilization
     */
    protected abstract void startup() throws Exception;
    public abstract JMenuBar getNavBar();
    private void setWindowDimension(int wPercentage,int hPercentage){
        this.windowDimension = new Dimension(Percentage.percentToNum(wPercentage, ((int)(Window.screenDimension.getWidth()))), Percentage.percentToNum(hPercentage, ((int) Window.screenDimension.getHeight())));

        this.jFrame.setSize(windowDimension);
    }

    public void closeWindow(){
        this.jFrame.dispose();
    }
    /**
     * Method to run after window has been initilized
     */
    protected  abstract void work();

    protected abstract void beforeVisible();

    protected abstract void afterVisible();

    //protected abstract void reloadWindow();

    protected abstract void onResize();

}

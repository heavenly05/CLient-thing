package qwerkcom;

import com.ACJ.Heaven.Graphics.WindowManager;

import qwerkcom.Components.Windows.AppWindow;

public final class AppManager{

    public static WindowManager windowManager = new WindowManager();


    public AppManager(){
    }

    public AppManager(WindowManager windowManager){
        setWindowManager(windowManager);
    }

    public AppManager(AppWindow window){
        setWindowManager(new WindowManager(window));
    }  


    public static WindowManager getWindowManager() {
        return AppManager.windowManager;
    }

    public static void setWindowManager(WindowManager windowManager) {
        AppManager.windowManager = windowManager;
    }


}

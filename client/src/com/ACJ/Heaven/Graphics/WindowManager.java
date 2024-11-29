package com.ACJ.Heaven.Graphics;

import com.ACJ.Heaven.Utilities.TrashMath.Random;
import java.util.HashMap;
@SuppressWarnings("OverridableMethodCallInConstructor")
public final class WindowManager {
     protected Window selectedWindow;
     protected HashMap<Integer, Window> windowMap = new HashMap<>();

     public WindowManager(){
        
     }

     public WindowManager(Window window){
        this.setCurrentWindow(addWindow(window));
     }

     public void switchWindow(int window_id){
        this.setCurrentWindow(window_id);
     }

     public void setCurrentWindow(int window_id){
        if(getCurrentWindow() != null){
            getCurrentWindow().closeWindow();
        }
        this.selectedWindow = getWindow(window_id);
        this.invokeWindow(window_id);
     }  

     public int addWindow(Window window){
         int window_id = Random.generateRandomNumber(10);
         windowMap.put(window_id, window);
         return window_id;
     }
     
     public void addCurrentWindow(Window window){
      this.setCurrentWindow(addWindow(window));
   }

     public void removeWindow(int window_id){
        getWindow(window_id).closeWindow();
        windowMap.remove(window_id);
     }

     public Window getCurrentWindow(){
        return this.selectedWindow;
     }

     public Window getWindow(int window_id){
         return windowMap.get(window_id);
     }


     public void invokeWindow(){
         this.selectedWindow.invoke();
         
     }
     
     public void invokeWindow(int window_id){
        if(getCurrentWindow() != null){
            getCurrentWindow().closeWindow();
        }
        this.selectedWindow = getWindow(window_id);
        getWindow(window_id).invoke();
     }
}

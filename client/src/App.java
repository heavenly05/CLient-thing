
import qwerkcom.AppManager;
import qwerkcom.Components.Windows.AppWindow;



public class App {

    public static void main(String[] args) throws Exception {


       
       AppManager.getWindowManager().addCurrentWindow(new AppWindow("qwerkcom"));

       
       //System.out.println(AppManager.getWindowManager());
    }
}

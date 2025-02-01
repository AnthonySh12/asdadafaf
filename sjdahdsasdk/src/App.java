

import UserInterface.Form.MenuForm;
//import UserInterface.Form.LoginFrame;
import UserInterface.Form.SplashScreen;

public class App {
    public static void main(String[] args) throws Exception {
        //SplashScreen.show();
        //SwingUtilities.invokeLater(() -> new LoginFrame());
        new MenuForm("Agendamiento de citas");
    }
}

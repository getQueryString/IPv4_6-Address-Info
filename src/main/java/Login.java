// Copyright© by Fin

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Login implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("Login.java");
        String usr = Main.userText.getText();
        String pw = Main.pwText.getText();
        if (usr.equals("1") && pw.equals("2")) {
            Main.denied.setVisible(false);
            Main.userLabel.setVisible(false);
            Main.userText.setVisible(false);
            Main.pwLabel.setVisible(false);
            Main.pwText.setVisible(false);
            Main.button.setVisible(false);
            Main.ipaddrlabel.setVisible(true);
            Main.ipaddrText.setVisible(true);
            Main.ipaddrbutton.setVisible(true);
        } else {
            Main.denied.setVisible(true);
        }
    }

}
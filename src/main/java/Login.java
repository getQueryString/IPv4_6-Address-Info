// Copyright© by Fin

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            Main.loginButton.setVisible(false);
            Main.ipaddrlabel.setVisible(true);
            Main.ipaddrText.setVisible(true);
            Main.ipaddrTrackButton.setVisible(true);
            Main.ipaddrLogoutButton.setVisible(true);
        } else if (!(usr.equals("")) && pw.equals("")) {
            Main.denied.setText("Password is missing!");
            Main.denied.setVisible(true);
        } else if (usr.equals("") && !(pw.equals(""))) {
            Main.denied.setText("Username is missing!");
            Main.denied.setVisible(true);
        } else if (usr.equals("") && pw.equals("")) {
            Main.denied.setText("Password & username is missing!");
            Main.denied.setVisible(true);
        } else {
            Main.denied.setText("Access denied!");
            Main.denied.setVisible(true);
        }
    }

}
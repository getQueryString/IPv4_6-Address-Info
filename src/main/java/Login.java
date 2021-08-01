// Copyright© by Fin

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    @Deprecated
    public void actionPerformed(ActionEvent e) {

        // Query
        String usr = Main.userText.getText();
        String pw = Main.pwText.getText();
        if (usr.equals("1") && pw.equals("2")) {

            // Change panel layout
            Main.denied.setVisible(false);

            // Label / Text
            Main.userLabel.setVisible(false);
            Main.userText.setVisible(false);
            Main.pwLabel.setVisible(false);
            Main.pwText.setVisible(false);
            Main.ipaddrlabel.setVisible(true);
            Main.ipaddrText.setVisible(true);
            Main.ipaddrTextInfo.setVisible(true);

            // Buttons
            Main.loginButton.setVisible(false);
            Main.ipaddrTrackButton.setVisible(true);
            Main.ipaddrLogoutButton.setVisible(true);

            // Clear JPanel_Track items
            if (!(Main.ipaddrText.getText().equals(""))) {
                Main.ipaddrText.setText("");
            }
            // Text
            Main.ip.setText("");
            Main.hostname.setText("");
            Main.orga.setText("");
            Main.location.setText("");
            Main.longlat.setText("");
            // Result
            Main.ip_result.setText("");
            Main.hostname_result.setText("");
            Main.orga_result.setText("");
            Main.location_result.setText("");
            Main.longlat_result.setText("");

            Main.userText.setText("");
            Main.pwText.setText("");
            Main.denied.setText("");

            JOptionPane optionPane = new JOptionPane("Successfully logged in", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog("Logged in");
            dialog.setIconImage(new ImageIcon("src/main/resources/TickedIcon.png").getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

            // Background audio
            Main.mii.stop();
            Main.mii_trap.start();

        } else if (!(usr.equals("")) && pw.equals("")) {
            Main.denied.setText("Password is missing!");
            Main.denied.setVisible(true);
            Main.userText.setText("");

        } else if (usr.equals("") && !(pw.equals(""))) {
            Main.denied.setText("Username is missing!");
            Main.denied.setVisible(true);
            Main.pwText.setText("");

        } else if (usr.equals("") && pw.equals("")) {
            Main.denied.setVisible(false);

            JOptionPane optionPane = new JOptionPane("Enter login details!", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Login error");
            dialog.setIconImage(new ImageIcon("src/main/resources/ErrorIcon.png").getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

        } else {
            Main.denied.setVisible(false);
            JOptionPane optionPane = new JOptionPane("Access denied!", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("Access denied");
            dialog.setIconImage(new ImageIcon("src/main/resources/ErrorIcon.png").getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

            Main.userText.setText("");
            Main.pwText.setText("");

        }
    }
}
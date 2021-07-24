// Copyright© by Fin

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

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

            Main.ip.setText("");
            Main.hostname.setText("");
            Main.orga.setText("");
            Main.location.setText("");
            Main.loc.setText("");

            Main.userText.setText("");
            Main.pwText.setText("");
            Main.denied.setText("");

            try {
                URL ticked_icon = new URL("https://i.ibb.co/NSjdhb9/Ticked-Icon.png");
                BufferedImage ticked = ImageIO.read(ticked_icon);

                JOptionPane optionPane = new JOptionPane("Successfully logged in", JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Logged in");
                dialog.setIconImage(ticked);
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } catch (Exception exception) {
                String[] options = {"Exit"};
                JOptionPane.showOptionDialog(Main.frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                System.exit(0);
            }
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
            try {
                URL error_icon = new URL("https://i.ibb.co/jhzPV13/Error-Icon.png");
                BufferedImage error = ImageIO.read(error_icon);

                JOptionPane optionPane = new JOptionPane("Enter login details!", JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("Login error");
                dialog.setIconImage(error);
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } catch (Exception exception) {
                String[] options = {"Exit"};
                JOptionPane.showOptionDialog(Main.frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                System.exit(0);
            }

        } else {
            Main.denied.setVisible(false);
            try {
                URL error_icon = new URL("https://i.ibb.co/jhzPV13/Error-Icon.png");
                BufferedImage error = ImageIO.read(error_icon);

                JOptionPane optionPane = new JOptionPane("Access denied!", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Access denied");
                dialog.setIconImage(error);
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

                Main.userText.setText("");
                Main.pwText.setText("");

            } catch (Exception exception) {
                String[] options = {"Exit"};
                JOptionPane.showOptionDialog(Main.frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                System.exit(0);
            }
        }
    }
}
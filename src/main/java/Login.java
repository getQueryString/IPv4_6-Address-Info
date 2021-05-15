// Copyright© by Fin

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
            /*Main.denied.setText("Password & username is missing!");
            Main.denied.setVisible(true);*/
            Main.denied.setVisible(false);
            JOptionPane optionPane = new JOptionPane("Enter login details!", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Login error");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

            /*try {

                File file = new File("src/main/resources/sound.mp3");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                JOptionPane optionPane = new JOptionPane(unsupportedAudioFileException, JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("UnsupportedAudioFileException");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            } catch (IOException ioException) {
                JOptionPane optionPane = new JOptionPane(ioException, JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("IOException");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            } catch (LineUnavailableException lineUnavailableException) {
                JOptionPane optionPane = new JOptionPane(lineUnavailableException, JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("LineUnavailableException");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }*/

        } else {
            /*Main.denied.setText("Access denied!");
            Main.denied.setVisible(true);*/

            Main.denied.setVisible(false);
            JOptionPane optionPane = new JOptionPane("Access denied!", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Access denied");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            System.exit(0);

        }
    }
}
// Copyright© by Fin

import jdk.nashorn.internal.scripts.JO;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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

            if (!(Main.ipaddrText.getText() == null)) {
                Main.ipaddrText.setText("");
            }

            JOptionPane optionPane = new JOptionPane("Successfully logged in", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, new ImageIcon("src/main/resources/TickedIcon.png"));
            JDialog dialog = optionPane.createDialog("Logged in");
            dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/TickedIcon.png"));
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

        } else if (!(usr.equals("")) && pw.equals("")) {
            Main.denied.setText("Password is missing!");
            Main.denied.setVisible(true);
            Main.userText.setText("");
        } else if (usr.equals("") && !(pw.equals(""))) {
            Main.denied.setText("Username is missing!");
            Main.denied.setVisible(true);
            Main.pwText.setText("");
        } else if (usr.equals("") && pw.equals("")) {
            /*Main.denied.setText("Password & username is missing!");
            Main.denied.setVisible(true);*/
            Main.denied.setVisible(false);
            JOptionPane optionPane = new JOptionPane("Enter login details!", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Login error");
            dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/ErrorIcon.png"));
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

            String file = "src/main/resources/LocationIcon.png";
            Icon icon = new ImageIcon(file);

            Main.denied.setVisible(false);
            JOptionPane optionPane = new JOptionPane("Access denied!", JOptionPane.ERROR_MESSAGE);
            //JOptionPane optionPane = new JOptionPane("Access denied!", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, icon);
            JDialog dialog = optionPane.createDialog("Access denied");

            dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/ErrorIcon.png"));
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            Main.userText.setText("");
            Main.pwText.setText("");
        }
    }
}
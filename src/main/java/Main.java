// Copyright© by Fin

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class Main extends JPanel {

    public static JPanel loginpanel;
    public static JLabel userLabel;
    public static JLabel ipaddrlabel;
    public static JLabel pwLabel;
    public static JLabel denied;
    public static JLabel ip;
    public static JLabel hostname;
    public static JLabel orga;
    public static JLabel location;
    public static JLabel loc;
    public static JTextField userText;
    public static JTextField ipaddrText;
    public static JPasswordField pwText;
    public static JButton button;
    public static JButton ipaddrbutton;


    public static void main(String[] args) throws IOException {
        // Settings
        loginpanel = new JPanel();
        loginpanel.setLayout(null);
        JMenuBar bar = new JMenuBar();
        JFrame frame = new JFrame("IPv4/6-Address-Info");
        frame.setSize(580, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(loginpanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Image image = ImageIO.read(new File("IPInfo-BackgroundImage.jpg"));
        JLabel img = new JLabel();
        img.setIcon(new ImageIcon(image));
        frame.add(img);

        // JMenu
        JMenu menu = new JMenu("Info");
        bar.add(menu);

        JMenuItem menuItem = new JMenuItem("Source code");
        menuItem.addActionListener(new Menu());
        menu.add(menuItem);

        frame.setJMenuBar(bar);

        // JPanel_Login
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        loginpanel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        loginpanel.add(userText);

        pwLabel = new JLabel("Password:");
        pwLabel.setBounds(10, 50, 80, 25);
        loginpanel.add(pwLabel);

        pwText = new JPasswordField();
        pwText.setBounds(100, 50, 165, 25);
        loginpanel.add(pwText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new Login());
        loginpanel.add(button);

        denied = new JLabel("Access denied!");
        denied.setBounds(10, 110, 100, 25);
        denied.setVisible(false);
        loginpanel.add(denied);

        // JPanel_Track
        ipaddrlabel = new JLabel("IPv4/6-Address:");
        ipaddrlabel.setBounds(10, 20, 100, 25);
        ipaddrlabel.setVisible(false);
        loginpanel.add(ipaddrlabel);

        ipaddrText = new JTextField(64);
        ipaddrText.setBounds(120, 20, 165, 25);
        ipaddrText.setVisible(false);
        loginpanel.add(ipaddrText);

        ipaddrbutton = new JButton("Track");
        ipaddrbutton.setBounds(10, 50, 80, 25);
        ipaddrbutton.setVisible(false);
        ipaddrbutton.addActionListener(new TrackIP());
        loginpanel.add(ipaddrbutton);

        ip = new JLabel("");
        ip.setBounds(10, 80, 400, 25);
        ip.setVisible(false);
        loginpanel.add(ip);

        hostname = new JLabel("");
        hostname.setBounds(10, 100, 400, 25);
        hostname.setVisible(false);
        loginpanel.add(hostname);

        orga = new JLabel("");
        orga.setBounds(10, 120, 400, 25);
        orga.setVisible(false);
        loginpanel.add(orga);

        location = new JLabel("");
        location.setBounds(10, 140, 400, 25);
        location.setVisible(false);
        loginpanel.add(location);

        loc = new JLabel("");
        loc.setBounds(10, 160, 400, 25);
        loc.setVisible(false);
        loginpanel.add(loc);

        frame.setVisible(true);

    }
}
// Copyright© by Fin

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

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

    /**
     * IDEAS:
     * Button for copying
     *
     * @param args
     * @return
     * @throws IOException
     */

    public static String OutputTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss,SS");
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(dtf);
    }

    public static String OutputDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyy");
        CharSequence text;
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(df);
    }

    public static void main(String[] args) throws IOException {
        // Settings
        loginpanel = new JPanel();
        loginpanel.setLayout(null);
        JMenuBar bar = new JMenuBar();
        JFrame frame = new JFrame("IPv4/6-Address-Info");
        frame.setSize(540, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(loginpanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
        //frame.setContentPane(new BackGroundPane("src/main/resources/IPInfo-BackgroundImage.jpg"));

        // JMenu
        JMenu menu = new JMenu("Info");
        menu.setFont(new Font("Courier New", Font.BOLD, 12));
        bar.add(menu);

        JMenuItem menuItem = new JMenuItem("Source code");
        menuItem.addActionListener(new Menu());
        menuItem.setFont(new Font("Courier New", Font.BOLD, 12));
        menuItem.setBackground(Color.YELLOW);
        menuItem.setForeground(Color.BLUE);
        menu.add(menuItem);

        frame.setJMenuBar(bar);

        // JPanel_Login
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        userLabel.setFont(new Font("Courier New", Font.BOLD, 14));
        userLabel.setForeground(Color.RED);
        loginpanel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        userText.setBackground(Color.BLACK);
        userText.setForeground(Color.YELLOW);
        loginpanel.add(userText);

        pwLabel = new JLabel("Password:");
        pwLabel.setBounds(10, 50, 80, 25);
        pwLabel.setForeground(Color.RED);
        loginpanel.add(pwLabel);

        pwText = new JPasswordField();
        pwText.setBounds(100, 50, 165, 25);
        pwText.setBackground(Color.BLACK);
        pwText.setForeground(Color.YELLOW);
        loginpanel.add(pwText);

        button = new JButton("Login", new ImageIcon("src/main/resources/LoginIcon.png"));
        button.setBounds(10, 80, 90, 25);
        button.addActionListener(new Login());
        loginpanel.add(button);

        denied = new JLabel("Access denied!");
        denied.setBounds(10, 110, 100, 25);
        denied.setForeground(Color.RED);
        denied.setVisible(false);
        loginpanel.add(denied);

        // JPanel_Track
        ipaddrlabel = new JLabel("IPv4/6-Address:");
        ipaddrlabel.setBounds(10, 20, 100, 25);
        ipaddrlabel.setForeground(Color.RED);
        ipaddrlabel.setVisible(false);
        loginpanel.add(ipaddrlabel);

        ipaddrText = new JTextField(64);
        ipaddrText.setBounds(120, 20, 165, 25);
        ipaddrText.setBackground(Color.BLACK);
        ipaddrText.setForeground(Color.YELLOW);
        ipaddrText.setVisible(false);
        loginpanel.add(ipaddrText);

        ipaddrbutton = new JButton("Track", new ImageIcon("src/main/resources/StartIcon.png"));
        ipaddrbutton.setBounds(10, 50, 90, 25);
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

        ip.setForeground(Color.BLUE);
        hostname.setForeground(Color.ORANGE);
        orga.setForeground(Color.GREEN);
        location.setForeground(Color.RED);
        loc.setForeground(Color.CYAN);

        frame.setVisible(true);

    }
}
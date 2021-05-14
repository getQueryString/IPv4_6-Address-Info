// Copyright© by Fin

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static JPanel loginPanel;
    public static JLabel userLabel;
    public static JLabel ipaddrlabel;
    public static JLabel pwLabel;
    public static JLabel denied;
    public static JLabel ip;
    public static JLabel hostname;
    public static JLabel orga;
    public static JLabel location;
    public static JTextField loc;
    public static JTextField userText;
    public static JTextField ipaddrText;
    public static JPasswordField pwText;
    public static JButton loginButton;
    public static JButton ipaddrTrackButton;
    public static JButton ipaddrLogoutButton;

    /**
     * IDEAS:
     * Button for copying
     * Button for logout
     */

    public static String OutputTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss,SS");
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(dtf);
    }

    public static String OutputDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyy");
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(df);
    }

    public static void main(String[] args) {
        // Settings
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        JMenuBar bar = new JMenuBar();
        JFrame frame = new JFrame("IPv4/6-Address-Info");
        frame.setSize(540, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(loginPanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
        //frame.setContentPane(new BackGroundPane("src/main/resources/IPInfo-BackgroundImage.jpg"));

        // JMenu
        JMenu data = new JMenu("File");
        data.setFont(new Font("Courier New", Font.BOLD, 12));
        bar.add(data);

        JMenuItem sourceCode = new JMenuItem("Source code");
        sourceCode.addActionListener(new Menu_File_Sourcecode());
        sourceCode.setFont(new Font("Courier New", Font.BOLD, 12));

        JSeparator line = new JSeparator();

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new Menu_File_Exit());
        exit.setFont(new Font("Courier New", Font.BOLD, 12));

        data.add(sourceCode);
        data.add(line);
        data.add(exit);

        frame.setJMenuBar(bar);

        // JPanel_Login
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        userLabel.setFont(new Font("Courier New", Font.BOLD, 14));
        userLabel.setForeground(Color.RED);
        loginPanel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        userText.setBackground(Color.BLACK);
        userText.setForeground(Color.YELLOW);
        loginPanel.add(userText);

        pwLabel = new JLabel("Password:");
        pwLabel.setBounds(10, 50, 80, 25);
        pwLabel.setForeground(Color.RED);
        loginPanel.add(pwLabel);

        pwText = new JPasswordField();
        pwText.setBounds(100, 50, 165, 25);
        pwText.setBackground(Color.BLACK);
        pwText.setForeground(Color.YELLOW);
        loginPanel.add(pwText);

        loginButton = new JButton("Login", new ImageIcon("src/main/resources/LoginIcon.png"));
        loginButton.setBounds(10, 80, 90, 25);
        loginButton.addActionListener(new Login());
        loginPanel.add(loginButton);

        denied = new JLabel();
        denied.setBounds(10, 110, 200, 25);
        denied.setForeground(Color.RED);
        denied.setVisible(false);
        loginPanel.add(denied);

        // JPanel_Track
        ipaddrlabel = new JLabel("IPv4/6-Address:");
        ipaddrlabel.setBounds(10, 20, 100, 25);
        ipaddrlabel.setForeground(Color.RED);
        ipaddrlabel.setVisible(false);
        loginPanel.add(ipaddrlabel);

        ipaddrText = new JTextField(64);
        ipaddrText.setBounds(120, 20, 165, 25);
        ipaddrText.setBackground(Color.BLACK);
        ipaddrText.setForeground(Color.YELLOW);
        ipaddrText.setVisible(false);
        loginPanel.add(ipaddrText);

        ipaddrTrackButton = new JButton("Track", new ImageIcon("src/main/resources/StartIcon.png"));
        ipaddrTrackButton.setBounds(10, 50, 90, 25);
        ipaddrTrackButton.setVisible(false);
        ipaddrTrackButton.addActionListener(new TrackIP());
        loginPanel.add(ipaddrTrackButton);

        ipaddrLogoutButton = new JButton("Logout", new ImageIcon("src/main/resources/LogoutIcon.png"));
        ipaddrLogoutButton.setBounds(415, 175, 100, 25);
        ipaddrLogoutButton.setVisible(false);
        ipaddrLogoutButton.addActionListener(new Logout());
        loginPanel.add(ipaddrLogoutButton);

        ip = new JLabel();
        ip.setBounds(10, 80, 400, 25);
        ip.setVisible(false);
        loginPanel.add(ip);

        hostname = new JLabel();
        hostname.setBounds(10, 100, 400, 25);
        hostname.setVisible(false);
        loginPanel.add(hostname);

        orga = new JLabel();
        orga.setBounds(10, 120, 400, 25);
        orga.setVisible(false);
        loginPanel.add(orga);

        location = new JLabel();
        location.setBounds(10, 140, 400, 25);
        location.setVisible(false);
        loginPanel.add(location);

        loc = new JTextField();
        loc.setBounds(10, 160, 400, 25);
        loc.setBorder(null);
        loc.setEditable(false);
        loc.setVisible(false);
        loginPanel.add(loc);

        ip.setForeground(Color.BLUE);
        hostname.setForeground(Color.BLACK);
        orga.setForeground(Color.RED);
        location.setForeground(Color.BLUE);
        loc.setForeground(Color.BLACK);

        frame.setVisible(true);
    }
}
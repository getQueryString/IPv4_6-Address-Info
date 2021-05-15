// Copyright© by Fin

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static JFrame frame;
    public static JCheckBoxMenuItem alwaysOnTop;
    public static JPanel jFramePanel;
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
    public static JButton loginButton;
    public static JButton ipaddrTrackButton;
    public static JButton ipaddrLogoutButton;
    public static JButton ipaddrCopyLocationResult;

    /**
     * IDEAS:
     * Button for copying       |
     * Button for logout        | CHECK
     * Struktogramm
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
        jFramePanel = new JPanel();
        jFramePanel.setLayout(null);
        JMenuBar bar = new JMenuBar();
        frame = new JFrame("IPv4/6-Address-Info");
        frame.setSize(540, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jFramePanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/LocationIcon.png"));
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
        //frame.setContentPane(new BackGroundPane("src/main/resources/IPInfo-BackgroundImage.jpg"));

        // JMenu File
        JMenu data = new JMenu("File");
        data.setFont(new Font("Courier New", Font.BOLD, 12));
        bar.add(data);

        JMenuItem sourceCode = new JMenuItem("Source code");
        sourceCode.addActionListener(new Menu_File_Sourcecode());
        sourceCode.setFont(new Font("Courier New", Font.BOLD, 12));
        data.add(sourceCode);

        JSeparator line = new JSeparator();
        data.add(line);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new Menu_File_Exit());
        exit.setFont(new Font("Courier New", Font.BOLD, 12));
        data.add(exit);

        // JMenu View
        JMenu view = new JMenu("View");
        view.setFont(new Font("Courier New", Font.BOLD, 12));
        bar.add(view);

        alwaysOnTop = new JCheckBoxMenuItem("In foreground");
        alwaysOnTop.addActionListener(new Menu_View_AlwaysOnTop());
        alwaysOnTop.setFont(new Font("Courier New", Font.BOLD, 12));
        alwaysOnTop.setSelected(true);
        frame.setAlwaysOnTop(true);
        view.add(alwaysOnTop);

        frame.setJMenuBar(bar);

        // JPanel_Login
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        userLabel.setFont(new Font("Courier New", Font.BOLD, 14));
        userLabel.setForeground(Color.RED);
        jFramePanel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        userText.setBackground(Color.BLACK);
        userText.setForeground(Color.YELLOW);
        jFramePanel.add(userText);

        pwLabel = new JLabel("Password:");
        pwLabel.setBounds(10, 50, 80, 25);
        pwLabel.setFont(new Font("Courier New", Font.BOLD, 14));
        pwLabel.setForeground(Color.RED);
        jFramePanel.add(pwLabel);

        pwText = new JPasswordField();
        pwText.setBounds(100, 50, 165, 25);
        pwText.setBackground(Color.BLACK);
        pwText.setForeground(Color.YELLOW);
        jFramePanel.add(pwText);

        loginButton = new JButton("Login", new ImageIcon("src/main/resources/LoginIcon.png"));
        loginButton.setBounds(10, 80, 90, 25);
        loginButton.setFont(loginButton.getFont().deriveFont(11f));
        loginButton.addActionListener(new Login());
        jFramePanel.add(loginButton);

        denied = new JLabel();
        denied.setBounds(10, 110, 200, 25);
        denied.setForeground(Color.RED);
        denied.setVisible(false);
        jFramePanel.add(denied);

        // JPanel_Track
        ipaddrlabel = new JLabel("IPv4/6-Address:");
        ipaddrlabel.setBounds(10, 20, 100, 25);
        ipaddrlabel.setForeground(Color.RED);
        ipaddrlabel.setVisible(false);
        jFramePanel.add(ipaddrlabel);

        ipaddrText = new JTextField(64);
        ipaddrText.setBounds(120, 20, 165, 25);
        ipaddrText.setBackground(Color.BLACK);
        ipaddrText.setForeground(Color.YELLOW);
        ipaddrText.setVisible(false);
        jFramePanel.add(ipaddrText);

        ipaddrTrackButton = new JButton("Track", new ImageIcon("src/main/resources/StartIcon.png"));
        ipaddrTrackButton.setBounds(10, 50, 90, 25);
        ipaddrTrackButton.setFont(ipaddrTrackButton.getFont().deriveFont(11f));
        ipaddrTrackButton.setVisible(false);
        ipaddrTrackButton.addActionListener(new TrackIP());
        jFramePanel.add(ipaddrTrackButton);

        ipaddrLogoutButton = new JButton("Logout", new ImageIcon("src/main/resources/LogoutIcon.png"));
        ipaddrLogoutButton.setBounds(414, 175, 101, 25);
        ipaddrLogoutButton.setFont(ipaddrLogoutButton.getFont().deriveFont(11f));
        ipaddrLogoutButton.setVisible(false);
        ipaddrLogoutButton.addActionListener(new Track_Logout_Function());
        jFramePanel.add(ipaddrLogoutButton);

        ipaddrCopyLocationResult = new JButton("Location", new ImageIcon("src/main/resources/CopyIcon.png"));
        ipaddrCopyLocationResult.setBounds(414, 145, 101, 25);
        ipaddrCopyLocationResult.setFont(ipaddrCopyLocationResult.getFont().deriveFont(11f));
        ipaddrCopyLocationResult.setVisible(false);
        jFramePanel.add(ipaddrCopyLocationResult);

        ip = new JLabel();
        ip.setBounds(10, 80, 400, 25);
        ip.setVisible(false);
        jFramePanel.add(ip);

        hostname = new JLabel();
        hostname.setBounds(10, 100, 400, 25);
        hostname.setVisible(false);
        jFramePanel.add(hostname);

        orga = new JLabel();
        orga.setBounds(10, 120, 400, 25);
        orga.setVisible(false);
        jFramePanel.add(orga);

        location = new JLabel();
        location.setBounds(10, 140, 400, 25);
        location.setVisible(false);
        jFramePanel.add(location);

        loc = new JLabel();
        loc.setBounds(10, 160, 400, 25);
        loc.setVisible(false);
        jFramePanel.add(loc);

        ip.setForeground(Color.BLUE);
        hostname.setForeground(Color.BLACK);
        orga.setForeground(Color.RED);
        location.setForeground(Color.BLUE);
        loc.setForeground(Color.BLACK);

        frame.setVisible(true);
    }
}
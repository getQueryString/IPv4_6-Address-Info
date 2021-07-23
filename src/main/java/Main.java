// Copyright© by Fin

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
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
    public static JLabel ipaddrTextInfo;
    public static JTextField userText;
    public static JTextField ipaddrText;
    public static JPasswordField pwText;
    public static JButton loginButton;
    public static JButton ipaddrTrackButton;
    public static JButton ipaddrLogoutButton;
    public static JButton ipaddrCLR;
    public static JButton ipaddrOpenTodaysFile;
    public static JSlider slider;
    public static JMenuBar bar;

    public static Clip mii;
    public static Clip mii_trap;

    public static FloatControl mii_floatControl;
    public static FloatControl mii_trap_floatControl;

    public static String eE = "ErrorException";

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

    public static void checkConnection() {
        try {
            URL check = new URL("https://imgbb.com");
            URLConnection connection = check.openConnection();
            connection.connect();
            connection.getInputStream().close();

        } catch (Exception exception) {
            String[] options = {"Try again"};
            int optionPane = JOptionPane.showOptionDialog(frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

            if (optionPane == JOptionPane.YES_OPTION) {
                checkConnection();
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        checkConnection();
        // Settings
        jFramePanel = new JPanel();
        jFramePanel.setLayout(null);
        bar = new JMenuBar();
        frame = new JFrame("IPv4/6-Address-Info");
        frame.setSize(540, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jFramePanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));

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

        // JMenu Sound
        JMenu sound = new JMenu("Sound");
        sound.setFont(new Font("Courier New", Font.BOLD, 12));
        bar.add(sound);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        //slider.addChangeListener(new Sound_BackgroundAudio());
        sound.add(slider);

        // Background audio
        try {
            File audio_mii = new File("src/main/resources/mii.wav");
            File audio_mii_trap = new File("src/main/resources/mii_trap.wav");
            AudioInputStream mii_audioInputStream = AudioSystem.getAudioInputStream(audio_mii);
            AudioInputStream mii_trap_audioInputStream = AudioSystem.getAudioInputStream(audio_mii_trap);

            mii = AudioSystem.getClip();
            mii.open(mii_audioInputStream);
            mii_floatControl = (FloatControl) mii.getControl(FloatControl.Type.MASTER_GAIN);
            mii.loop(Clip.LOOP_CONTINUOUSLY);

            mii_trap = AudioSystem.getClip();
            mii_trap.open(mii_trap_audioInputStream);
            mii_trap_floatControl = (FloatControl) mii_trap.getControl(FloatControl.Type.MASTER_GAIN);
            mii_trap.loop(Clip.LOOP_CONTINUOUSLY);
            mii_trap.stop();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            String[] options = {"Continue"};
            JOptionPane.showOptionDialog(frame, ex, eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            System.exit(0);
        }


        // Set bar
        frame.setJMenuBar(bar);

        // JPanel_Login
        // Username
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

        // Password
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

        // Access denied
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

        ipaddrText = new JTextField();
        ipaddrText.setBounds(120, 20, 280, 25);
        ipaddrText.setBackground(Color.BLACK);
        ipaddrText.setForeground(Color.YELLOW);
        ipaddrText.setEditable(false);
        ipaddrText.setVisible(false);
        jFramePanel.add(ipaddrText);

        ipaddrTextInfo = new JLabel("COPY IP-ADDRESS INTO CLIPBOARD!");
        ipaddrTextInfo.setBounds(120, 50, 208, 25);
        ipaddrTextInfo.setForeground(Color.RED);
        ipaddrTextInfo.setVisible(false);
        jFramePanel.add(ipaddrTextInfo);

        // Track output
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

        // Set color
        ip.setForeground(Color.BLUE);
        hostname.setForeground(Color.BLACK);
        orga.setForeground(Color.RED);
        location.setForeground(Color.BLUE);
        loc.setForeground(Color.BLACK);

        // Attempted connection
        try {
            URL login_icon = new URL("https://i.ibb.co/NSjdhb9/Ticked-Icon.png");
            URL start_icon = new URL("https://i.ibb.co/NSjdhb9/Ticked-Icon.png");
            URL logout_icon = new URL("https://i.ibb.co/NSjdhb9/Ticked-Icon.png");
            URL copy_icon = new URL("https://i.ibb.co/NSjdhb9/Ticked-Icon.png");
            URL location_icon = new URL("https://i.ibb.co/NSjdhb9/Ticked-Icon.png");
            URL openfolder_icon = new URL("https://i.ibb.co/NSjdhb9/Ticked-Icon.png");

            BufferedImage login = ImageIO.read(login_icon);
            BufferedImage start = ImageIO.read(start_icon);
            BufferedImage logout = ImageIO.read(logout_icon);
            BufferedImage copy = ImageIO.read(copy_icon);
            BufferedImage location = ImageIO.read(location_icon);
            BufferedImage openfolder = ImageIO.read(openfolder_icon);

            frame.setIconImage(location);

            // Buttons
            // JPanel_Login
            // loginButton = new JButton("Login", new ImageIcon("src/main/resources/LoginIcon.png"));
            loginButton = new JButton("Login", new ImageIcon(login));
            loginButton.setBounds(10, 80, 90, 25);
            loginButton.setFont(loginButton.getFont().deriveFont(11f));
            loginButton.addActionListener(new Login());
            jFramePanel.add(loginButton);

            // JPanel_Track
            ipaddrTrackButton = new JButton("Track", new ImageIcon(start));
            ipaddrTrackButton.setBounds(10, 50, 90, 25);
            ipaddrTrackButton.setFont(ipaddrTrackButton.getFont().deriveFont(11f));
            ipaddrTrackButton.setVisible(false);
            ipaddrTrackButton.addActionListener(new TrackIP());
            jFramePanel.add(ipaddrTrackButton);

            ipaddrLogoutButton = new JButton("Logout", new ImageIcon(logout));
            ipaddrLogoutButton.setBounds(414, 175, 101, 25);
            ipaddrLogoutButton.setFont(ipaddrLogoutButton.getFont().deriveFont(11f));
            ipaddrLogoutButton.setVisible(false);
            ipaddrLogoutButton.addActionListener(new Track_Logout_Function());
            jFramePanel.add(ipaddrLogoutButton);

            ipaddrCLR = new JButton("Location", new ImageIcon(copy));
            ipaddrCLR.setBounds(414, 145, 101, 25);
            ipaddrCLR.setFont(ipaddrCLR.getFont().deriveFont(11f));
            ipaddrCLR.setVisible(false);
            ipaddrCLR.addActionListener(new Track_CLR_Function());
            jFramePanel.add(ipaddrCLR);

            ipaddrOpenTodaysFile = new JButton("Today's", new ImageIcon(openfolder));
            ipaddrOpenTodaysFile.setBounds(414, 115, 101, 25);
            ipaddrOpenTodaysFile.setFont(ipaddrOpenTodaysFile.getFont().deriveFont(11f));
            ipaddrOpenTodaysFile.setVisible(false);
            ipaddrOpenTodaysFile.addActionListener(new Track_OpenTodaysFile_Function());
            jFramePanel.add(ipaddrOpenTodaysFile);

        } catch (Exception exception) {
            String[] options = {"Exit"};
            JOptionPane.showOptionDialog(frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            System.exit(0);
        }

        frame.setVisible(true);
    }
}
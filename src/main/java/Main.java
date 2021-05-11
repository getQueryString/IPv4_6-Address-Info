// Copyright© by Fin

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {

    private static JPanel panel;
    private static JLabel userLabel;
    public static JLabel ipaddrlabel;
    private static JTextField userText;
    public static JTextField ipaddrText;
    private static JLabel pwLabel;
    public static JLabel ip;
    public static JLabel hostname;
    public static JLabel orga;
    public static JLabel location;
    public static JLabel loc;
    private static JPasswordField pwText;
    private static JButton button;
    public static JButton ipaddrbutton;

    public static void main(String[] args) {
        panel = new JPanel();
        JFrame frame = new JFrame("IPv4/6-Address-Info");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        pwLabel = new JLabel("Password:");
        pwLabel.setBounds(10, 50, 80, 25);
        panel.add(pwLabel);

        pwText = new JPasswordField();
        pwText.setBounds(100, 50, 165, 25);
        panel.add(pwText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new Main());
        panel.add(button);

        ipaddrlabel = new JLabel("");
        ipaddrlabel.setBounds(10, 20, 100, 25);
        ipaddrlabel.setVisible(false);
        panel.add(ipaddrlabel);

        ipaddrText = new JTextField(64);
        ipaddrText.setBounds(120, 20, 165, 25);
        ipaddrText.setVisible(false);
        panel.add(ipaddrText);

        ipaddrbutton = new JButton("Track");
        ipaddrbutton.setBounds(10, 50, 80, 25);
        ipaddrbutton.setVisible(false);
        ipaddrbutton.addActionListener(new TrackIP());
        panel.add(ipaddrbutton);

        ip = new JLabel("");
        ip.setBounds(10, 80, 400, 25);
        ip.setVisible(false);
        panel.add(ip);

        hostname = new JLabel("");
        hostname.setBounds(10, 100, 400, 25);
        hostname.setVisible(false);
        panel.add(hostname);

        orga = new JLabel("");
        orga.setBounds(10, 120, 400, 25);
        orga.setVisible(false);
        panel.add(orga);

        location = new JLabel("");
        location.setBounds(10, 140, 400, 25);
        location.setVisible(false);
        panel.add(location);

        loc = new JLabel("");
        loc.setBounds(10, 160, 400, 25);
        loc.setVisible(false);
        panel.add(loc);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String usr = userText.getText();
        String pw = pwText.getText();

        if (usr.equals("1") && pw.equals("2")) {
            userLabel.setVisible(false);
            userText.setVisible(false);
            pwLabel.setVisible(false);
            pwText.setVisible(false);
            button.setVisible(false);
            ipaddrlabel.setVisible(true);
            ipaddrText.setVisible(true);
            ipaddrbutton.setVisible(true);
            ipaddrlabel.setText("IPv4/6-Address:");
        }
    }
}
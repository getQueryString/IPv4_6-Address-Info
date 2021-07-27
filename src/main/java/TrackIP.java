// Copyright© by Fin

import io.ipinfo.api.IPInfo;
import io.ipinfo.api.model.IPResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrackIP implements ActionListener {

    public static IPResponse response;

    // Check availability of IP address
    Pattern pattern_ipv4;
    Pattern pattern_ipv6;
    Matcher matcher_ipv4;
    Matcher matcher_ipv6;

    // String
    static final String IP_ADDRESS_REGEX_IPV4 = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    static final String IP_ADDRESS_REGEX_IPV6 = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";

    public void actionPerformed(ActionEvent e) {
        startTrack();
    }

    public void startTrack() {
        Main.ipaddrText.setText("");
        // Start check-method for available IP address
        TrackIP ipAddrValid = new TrackIP();

        // Change panel layout
        // JPanel_Track items
        // Text
        Main.ip.setVisible(true);
        Main.hostname.setVisible(true);
        Main.orga.setVisible(true);
        Main.location.setVisible(true);
        Main.loc.setVisible(true);
        // Result
        Main.ip_result.setVisible(true);
        Main.hostname_result.setVisible(true);
        Main.orga_result.setVisible(true);
        Main.location_result.setVisible(true);
        Main.loc_result.setVisible(true);

        // Paste clipboard / continue with own
        try {
            String clipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

            if (ipAddrValid.validate_ipv4(clipboard) == true || ipAddrValid.validate_ipv6(clipboard) == true) {
                Main.ipaddrText.setText(clipboard);
                IPInfoBuild();

            } else {
                String[] options = {"Continue"};
                JOptionPane.showOptionDialog(Main.frame, "*No information about the IP address\n*IPv4/6 address cannot contain spaces\n*Clipboard does not contain an IPv4/6 address", Main.eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

            }
        } catch (Exception exception) {
            IPInfoBuild();
        }
    }

    public void IPInfoBuild() {

        // Buttons
        Main.ipaddrCLR.setVisible(true);
        Main.ipaddrOpenTodaysFile.setVisible(true);

        IPInfo ipInfo = IPInfo.builder().build();

        // Get address-info
        try {
            response = ipInfo.lookupIP(Main.ipaddrText.getText());

            // Text
            Main.ip.setText("IPv4/6-Address");
            Main.hostname.setText("Hostname");
            Main.orga.setText("Organisation");
            Main.location.setText("Country");
            Main.loc.setText("Location");
            // Result
            Main.ip_result.setText(": " + response.getIp());
            Main.hostname_result.setText(": " + response.getHostname());
            Main.orga_result.setText(": " + response.getOrg());
            Main.location_result.setText(": " + response.getCountryCode() + ", " + response.getRegion() + "; " + response.getPostal() + ", " + response.getCity());
            Main.loc_result.setText(": " + response.getLocation());

        } catch (Exception exception) {
            String[] options = {"Continue"};
            JOptionPane.showOptionDialog(Main.frame, exception, Main.eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        }

        // Save today's address-info
        try {
            FileWriter writer;
            File dat = new File("logs\\addrinf(" + Main.OutputDate() + ").log");
            File dir = new File("logs");
            if (!dir.exists()) {
                try {
                    dir.mkdir();
                } catch (Exception e) {

                }
            }
            writer = new FileWriter(dat, true);
            writer.write("- - - - - - Time: " + Main.OutputTime() + " - - - - - -\n"
                    + "IPv4/6-Address : " + response.getIp() + "\n"
                    + "Hostname       : " + response.getHostname() + "\n"
                    + "Organisation   : " + response.getOrg() + "\n"
                    + "Country        : " + response.getCountryCode() + ", " + response.getRegion() + "; " + response.getPostal() + ", " + response.getCity()
                    + "\n"
                    + "Location       : " + response.getLocation() + "\n\n");
            writer.flush();
            writer.close();

        } catch (Exception exception) {
            String[] options = {"Continue"};
            JOptionPane.showOptionDialog(Main.frame, exception, Main.eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        }
    }

    public TrackIP() {
        pattern_ipv4 = Pattern.compile(IP_ADDRESS_REGEX_IPV4);
        pattern_ipv6 = Pattern.compile(IP_ADDRESS_REGEX_IPV6);
    }

    public boolean validate_ipv4(final String ipAddress) {
        matcher_ipv4 = pattern_ipv4.matcher(ipAddress);
        return matcher_ipv4.matches();
    }

    public boolean validate_ipv6(final String ipAddress) {
        matcher_ipv6 = pattern_ipv6.matcher(ipAddress);
        return matcher_ipv6.matches();
    }
}
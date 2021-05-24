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

public class TrackIP implements ActionListener {

    public static IPResponse response;

    public void actionPerformed(ActionEvent e) {

        // Change panel layout
        // JPanel_Track items
        Main.ip.setVisible(true);
        Main.hostname.setVisible(true);
        Main.orga.setVisible(true);
        Main.location.setVisible(true);
        Main.loc.setVisible(true);

        // Buttons
        Main.ipaddrCopyLocationResult.setVisible(true);
        Main.ipaddrCopyLocationResult.addActionListener(new Track_CopyLocationResult_Function());
        Main.ipaddrOpenTodaysFile.setVisible(true);

        // Paste clipboard / continue with own
        try {
            String clipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            if ((clipboard.contains(".")) || (clipboard.contains(":"))) {
                Main.ipaddrText.setText(clipboard);
                IPInfoBuild();
            } else {
                String[] options = {"Continue"};
                JOptionPane.showOptionDialog(Main.frame, "Clipboard does'nt contain a possible IPv4/6-address!", "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            }
        } catch (Exception exception) {
            String[] options = {"Proceed with own ip-address"};
            JOptionPane.showOptionDialog(Main.frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            Main.ipaddrText.setText("");
        }
    }

    public void IPInfoBuild() {
        System.out.println("SEARCH");
        IPInfo ipInfo = IPInfo.builder().build();

        // Get address-info
        try {
            response = ipInfo.lookupIP(Main.ipaddrText.getText());
            Main.ip.setText("IPv4/6-Address : " + response.getIp());
            Main.hostname.setText("Hostname           : " + response.getHostname());
            Main.orga.setText("Organisation      : " + response.getOrg());
            Main.location.setText("Country                : " + response.getCountryCode() + ", " + response.getRegion() + "; " + response.getPostal() + ", " + response.getCity());
            Main.loc.setText("Location              : " + response.getLocation());

        } catch (Exception exception) {
            String[] options = {"Continue"};
            JOptionPane.showOptionDialog(Main.frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        }

        // Save today's address-info
        if (!Main.location.getText().contains("null")) {
            try {
                FileWriter writer;
                File dat = new File("addrinf(" + Main.OutputDate() + ").log");
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
                JOptionPane.showOptionDialog(Main.frame, exception, "ErrorException", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            }
        }
    }
}
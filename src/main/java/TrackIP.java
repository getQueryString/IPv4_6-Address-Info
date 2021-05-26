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
    private String eE = "ErrorException";

    public void actionPerformed(ActionEvent e) {
        startTrack();
    }

    public void startTrack() {
        // Change panel layout
        // JPanel_Track items
        Main.ip.setVisible(true);
        Main.hostname.setVisible(true);
        Main.orga.setVisible(true);
        Main.location.setVisible(true);
        Main.loc.setVisible(true);

        // Paste clipboard / continue with own
        try {
            String clipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

            int pC = 0;
            int cC = 0;
            char ptemp;
            char ctemp;
            for (int p = 0; p < clipboard.length(); p++) {
                ptemp = clipboard.charAt(p);
                ctemp = clipboard.charAt(p);
                if (ptemp == '.') {
                    pC++;
                }
                if (ctemp == ':') {
                    cC++;
                }
            }

            if (clipboard.matches("^[a-zA-Z0-9.:]+$") && (clipboard.contains(":") || clipboard.contains(".")
                    && !clipboard.contains(" ")) && clipboard.length() >= 7 && (pC == 3 || (cC >= 5 && cC <= 7))) {
                Main.ipaddrText.setText(clipboard);
                IPInfoBuild();

            } else {
                String[] options = {"Continue"};
                JOptionPane.showOptionDialog(Main.frame, "Clipboard does'nt contain a possible IPv4/6-address!", eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

            }
        } catch (Exception exception) {
            IPInfoBuild();
        }
    }

    public void IPInfoBuild() {

        // Buttons
        Main.ipaddrCopyLocationResult.setVisible(true);
        Main.ipaddrCopyLocationResult.addActionListener(new Track_CLR_Function());
        Main.ipaddrOpenTodaysFile.setVisible(true);

        IPInfo ipInfo = IPInfo.builder().build();

        // Get address-info
        try {
            response = ipInfo.lookupIP(Main.ipaddrText.getText());
            Main.ip.setText("IPv4/6-Address : " + response.getIp());
            if (!Main.ip.getText().contains("null")) {
                Main.hostname.setText("Hostname           : " + response.getHostname());
                Main.orga.setText("Organisation      : " + response.getOrg());
                Main.location.setText("Country                : " + response.getCountryCode() + ", " + response.getRegion() + "; " + response.getPostal() + ", " + response.getCity());
                Main.loc.setText("Location              : " + response.getLocation());

            } else {
                // JPanel_Track items
                Main.hostname.setVisible(false);
                Main.orga.setVisible(false);
                Main.location.setVisible(false);
                Main.loc.setVisible(false);
                Main.location.setText("null");
                String[] options = {"Continue"};
                JOptionPane.showOptionDialog(Main.frame, "IP-address not found!", eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

            }
        } catch (Exception exception) {
            String[] options = {"Continue"};
            JOptionPane.showOptionDialog(Main.frame, exception, eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
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
                JOptionPane.showOptionDialog(Main.frame, exception, eE, JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            }
        }
    }
}
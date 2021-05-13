// Copyright© by Fin

import io.ipinfo.api.IPInfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TrackIP implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("TrackIP.java");
        Main.ip.setVisible(true);
        Main.hostname.setVisible(true);
        Main.orga.setVisible(true);
        Main.location.setVisible(true);
        Main.loc.setVisible(true);
        //IPInfo ipInfo = IPInfo.builder().setToken("TOKEN").build();
        IPInfo ipInfo = IPInfo.builder().build();

        try {
            IPResponse response = ipInfo.lookupIP(Main.ipaddrText.getText());
            System.out.println("IRespone successful");
            Main.ip.setText("IPv4/6-Address : " + response.getIp());
            Main.hostname.setText("Hostname           : " + response.getHostname());
            Main.orga.setText("Organisation      : " + response.getOrg());
            Main.location.setText("Country                : " + response.getCountryCode() + ", " + response.getRegion() + "; " + response.getPostal() + ", " + response.getCity());
            Main.loc.setText("Location              : " + response.getLocation());


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

        } catch (RateLimitedException | IOException ex) {
            System.out.println(ex);
        }
    }
}
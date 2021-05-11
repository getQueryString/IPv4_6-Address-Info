// Copyright© by Fin

import io.ipinfo.api.IPInfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackIP implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("Funzt!");
        Main.ip.setVisible(true);
        Main.hostname.setVisible(true);
        Main.orga.setVisible(true);
        Main.location.setVisible(true);
        Main.loc.setVisible(true);
        IPInfo ipInfo = IPInfo.builder().setToken("TOKEN").build();

        try {
            IPResponse response = ipInfo.lookupIP(Main.ipaddrText.getText());
            System.out.println("Response");
            Main.ip.setText("IPv4/6-Address : " + response.getIp());
            Main.hostname.setText("Hostname           : " + response.getHostname());
            Main.orga.setText("Organisation      : " + response.getOrg());
            Main.location.setText("Country                : " + response.getCountryCode() + ", " + response.getRegion() + "; " + response.getPostal() + ", " + response.getCity());
            Main.loc.setText("Location              : " + response.getLocation());
        } catch (RateLimitedException ex) {
            System.out.print(ex);
        }
    }
}
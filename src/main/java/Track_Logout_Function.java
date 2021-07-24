// Copyright© by Fin

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Track_Logout_Function implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        // Change panel layout
        Main.denied.setVisible(true);
        Main.userLabel.setVisible(true);
        Main.userText.setVisible(true);
        Main.pwLabel.setVisible(true);
        Main.pwText.setVisible(true);
        Main.loginButton.setVisible(true);
        Main.ipaddrlabel.setVisible(false);
        Main.ipaddrText.setVisible(false);
        Main.ipaddrTextInfo.setVisible(false);

        // Buttons
        Main.ipaddrTrackButton.setVisible(false);
        Main.ipaddrCLR.setVisible(false);
        Main.ipaddrLogoutButton.setVisible(false);
        Main.ipaddrOpenTodaysFile.setVisible(false);

        // JPanel_Track items
        Main.ip.setVisible(false);
        Main.hostname.setVisible(false);
        Main.orga.setVisible(false);
        Main.location.setVisible(false);
        Main.loc.setVisible(false);

        // Background audio
        Main.mii_trap.stop();
        Main.mii.start();
    }
}
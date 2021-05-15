// Copyright© by Fin

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Track_CopyLocationResult_Function implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        StringSelection locationText = new StringSelection("https://www.google.com/maps/search/" + TrackIP.response.getLocation());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(locationText, null);
    }
}
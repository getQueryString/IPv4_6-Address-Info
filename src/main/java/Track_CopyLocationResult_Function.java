// Copyright© by Fin

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Track_CopyLocationResult_Function implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Main.location.getText().contains("null")) {
            StringSelection locationText = new StringSelection("https://www.google.com/maps/search/" + TrackIP.response.getLocation());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(locationText, null);
        } else {

            /*String[] options = {"Continue"};
            JOptionPane.showOptionDialog(Main.frame, "Nothing to copy!", "ErrorException", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);*/

            JOptionPane optionPane = new JOptionPane("Nothing to copy!", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("ErrorException");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }
}
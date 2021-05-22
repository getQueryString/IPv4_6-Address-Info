// Copyright© by Fin

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Track_OpenTodaysFile_Function implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        // Open today's address-info file
        try {
            Desktop.getDesktop().open(new File("addrinf(" + Main.OutputDate() + ").log"));
        } catch (Exception exception) {

            String[] options = {"Continue"};
            JOptionPane.showOptionDialog(Main.frame, exception, "ErrorException", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        }
    }
}
// Copyright© by Fin

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_View_AlwaysOnTop implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        if (Main.alwaysOnTop.isSelected()) {
            Main.frame.setAlwaysOnTop(true);
        } else {
            Main.frame.setAlwaysOnTop(false);
        }
    }
}
// Copyright© by Fin

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class Menu implements ActionListener {


    public void actionPerformed(ActionEvent e) {
        try{
            URI uri = new URI("https://github.com/getQueryString/IPv4_6-Address-Info");
            Desktop.getDesktop().browse(uri);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
// Copyright© by Fin

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Sound_BackgroundAudio implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {
        Main.mii_floatControl.setValue(20f * (float) Math.log10(Main.slider.getValue() / 100));
        System.out.println("" + Main.slider.getValue());

    }
}
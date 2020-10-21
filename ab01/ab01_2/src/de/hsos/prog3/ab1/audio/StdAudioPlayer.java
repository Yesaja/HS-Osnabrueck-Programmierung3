package de.hsos.prog3.ab1.audio;

import java.io.IOException;
import java.net.URL;

public interface StdAudioPlayer {
    //um die mit dem Übergabeparameter definierte wav‐Datei einmalig abzuspielen
    void einmaligAbspeilen(URL url) throws IOException;
    //Übergabeparameter legt fest, wie häufig der Player die definierte wav‐Datei wiederholtabspielt.
    void wiederholtAbspeilen(URL url, int wiederholungen) throws IOException;

    void tonAus();
    void tonAn();

}

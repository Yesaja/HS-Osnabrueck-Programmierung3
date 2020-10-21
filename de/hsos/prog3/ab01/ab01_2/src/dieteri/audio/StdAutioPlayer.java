package src.dieteri.audio;

import java.io.IOException;
import java.net.URL;

public interface StdAutioPlayer{
    //um die mit dem Übergabeparameter definierte wav‐Datei einmalig abzuspielen
    void einmaligAbspeichern(URL url) throws IOException;
    //Übergabeparameter legt fest, wie häufig der Player die definierte wav‐Datei wiederholtabspielt.
    void wiederholtAbspeilen(URL url, int wiederholungen) throws IOException;

    void tonAus();
    void tonAn();

}

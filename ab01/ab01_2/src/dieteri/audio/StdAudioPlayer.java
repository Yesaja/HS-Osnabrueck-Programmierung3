package ab01.ab01_2.src.dieteri.audio;

import java.io.IOException;
import java.net.URL;

public interface StdAudioPlayer {
    //um die mit dem Übergabeparameter definierte wav‐Datei einmalig abzuspielen
    void einmaligAbspielen(URL url) throws IOException;
    //Übergabeparameter legt fest, wie häufig der Player die definierte wav‐Datei wiederholtabspielt.
    void wiederholtAbspielen(URL url, int wiederholungen) throws IOException;

    void tonAus();
    void tonAn();

}

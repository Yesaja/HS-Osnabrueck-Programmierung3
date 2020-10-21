package src.dieteri.audio;

import de.hsos.prog3.audio.SimpleAudioPlayer;

import java.io.IOException;
import java.net.URL;

public class SimpleAudioPlayerAdapter implements StdAudioPlayer {
    private SimpleAudioPlayer player;
    @Override
    public void einmaligAbspielen(URL url) throws IOException {
        if(player == null)
            player = new SimpleAudioPlayer(url);
        player.play(0);
    }

    @Override
    public void wiederholtAbspielen(URL url, int wiederholungen) throws IOException {
        for (int i = 0; i <= wiederholungen ; i++) {
            einmaligAbspielen(url);
        }
    }

    @Override
    public void tonAus() {
        if(player != null){
            player.setDebug(true);
            player.verboseLogging(true);
            System.out.println("Ton wurde Ausgeschaltet");
        }
    }

    @Override
    public void tonAn() {
        if(player != null){
            player.setDebug(false);
            player.verboseLogging(true);
            System.out.println("Ton wurde angeschaltet");
        }
    }
}
package ab01.ab01_2.src.dieteri.audio.adapter;

import java.io.IOException;
import java.net.URL;

import de.hsos.prog3.audio.SimpleAudioPlayer;

public class SimpleAudioPlayerAdapter implements ab01.ab01_2.src.dieteri.audio.StdAudioPlayer {
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
            System.out.println("Ton wurde ausgeschaltet");
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
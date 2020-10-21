package de.hsos.prog3.ab1.audio;

import de.hsos.prog3.audio.SimpleAudioPlayer;

import java.io.IOException;
import java.net.URL;

public class SimpleAudioPlayerAdapter implements StdAudioPlayer {
    private SimpleAudioPlayer player;
    @Override
    public void einmaligAbspeilen(URL url) throws IOException {
        if(player == null)
            player = new SimpleAudioPlayer(url);
        player.play(0);
    }

    @Override
    public void wiederholtAbspeilen(URL url, int wiederholungen) throws IOException {
        for (int i = 0; i <= wiederholungen ; i++) {
            einmaligAbspeilen(url);
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
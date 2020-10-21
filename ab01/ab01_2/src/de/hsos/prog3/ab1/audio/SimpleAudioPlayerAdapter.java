package de.hsos.prog3.ab1.audio;

import de.hsos.prog3.audio.SimpleAudioPlayer;

import java.io.IOException;
import java.net.URL;

public class SimpleAudioPlayerAdapter implements  StdAutioPlayer{
    SimpleAudioPlayer player;
    @Override
    public void einmaligAbspeichern(URL url) throws IOException {
        player = new SimpleAudioPlayer(url);
        player.setDebug(false);
        player.verboseLogging(true);
        player.play(0);
    }

    @Override
    public void wiederholtAbspeilen(URL url, int wiederholungen) {

    }
}
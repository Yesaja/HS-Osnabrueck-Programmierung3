/*

package ab01.ab01_2.src.dieteri.orchester;

import java.io.IOException;

import src.dieteri.audio.StdAudioPlayer;
import src.dieteri.audio.adapter.SimpleAudioPlayerAdapter;
//import src.dieteri.orchester.Verhalten;


public class Probe implements Verhalten {
    public void spielen(Orchester orchester) {
        if(orchester.getMusikerInnen() != null) {
            for(MusikerIn m : orchester.getMusikerInnen()) {
                StdAudioPlayer pAdapter = new SimpleAudioPlayerAdapter();
                try {
                    pAdapter.tonAus();
                    pAdapter.einmaligAbspielen(App.class.getResource(m.getInstrument().getAudio()));
                } catch(IOException e) {
                e.printStackTrace();
                //e.getMessage();
                System.out.println("Probe wird abgebrochen!");
                }
            }
        }
    }
}
*/
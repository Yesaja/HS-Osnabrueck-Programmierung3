package src.dieteri.orchester;

import java.io.IOException;

import src.dieteri.audio.adapter.StdAudioPlayer;
import src.dieteri.audio.adapter.SimpleAudioPlayerAdapter;
import src.dieteri.orchester.Verhalten;


public class Probe implements Verhalten{
    public void spielen(Orchester orchester) {
        if(orchester.getMusikerInnen() != null){
            for( MusikerIn m : orchester.getMusikerInnen()){
                StdAudioPlayer pAdapter = SimpleAudioPlayerAdapter();
                try{
                    pAdapter.einmaligAbspielen(Main.class.getResource(m.getInstrument().getAudio()));
                }catch(IOException e){
                e.printStackTrace();
                //e.getMessage();
                System.out.println("Probe wird abgebrochen");
            }
        }
    }
}

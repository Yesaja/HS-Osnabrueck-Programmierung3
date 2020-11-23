package ab01.ab01_2.src.dieteri.orchester;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

import ab01.ab01_2.src.dieteri.audio.StdAudioPlayer;
import ab01.ab01_2.src.dieteri.audio.adapter.SimpleAudioPlayerAdapter;

public class Orchester {
    private String bezeichnung;
    private DirigentIn dirigentIn;
    private HashSet<MusikerIn> musikerInnen;
    private Verhalten verhalten;
    private String audioDateiKonzert;

    public Orchester(String bezeichnung, String audioDateiKonzert) {
        this.bezeichnung = bezeichnung;
        this.audioDateiKonzert = audioDateiKonzert;
        this.musikerInnen = new HashSet<MusikerIn>();
    }
    
    public void addDirigentIn(DirigentIn dirigentIn) {
        this.dirigentIn = dirigentIn;
    }

    public void addMusikerIn(MusikerIn musikerIn) {
        this.musikerInnen.add(musikerIn);
    }

    public HashSet<MusikerIn> getMusikerInnen() {
        return musikerInnen;
    }

    public URL getAudiodateiKonzert() { 
        return App.class.getResource(audioDateiKonzert);
    }

    public void proben() {
        //setzt ein Objekt vom Typ Probe für die Instanzvariable verhalten
        verhalten = new Probe();
    }

    public void auftreten() {
        //setzt ein Objekt vom Typ Auftritt für die Instanzvariable verhalten
        verhalten = new Konzert();
    }

    public void spielen() {
        verhalten.spielen(this);
    }

    @Override
    public String toString() {
        return "Es spielt das Orchester " + bezeichnung + " unter der Leitung von " + dirigentIn + " und den Musikern " + musikerInnen;
    }


    //inner class Probe of Orchester
    private class Probe implements Verhalten {
        public void spielen(Orchester orchester) {
            if(orchester.getMusikerInnen() != null) {
                for(MusikerIn m : orchester.getMusikerInnen()) {
                    StdAudioPlayer pAdapter = new SimpleAudioPlayerAdapter();
                    try {
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
     //inner class Konzert of Orchester
    private class Konzert implements Verhalten {
        public void spielen(Orchester orchester) {
            if(orchester.getMusikerInnen() != null) {
                    StdAudioPlayer pAdapter = new SimpleAudioPlayerAdapter();
                    try {
                        pAdapter.einmaligAbspielen(orchester.getAudiodateiKonzert());
                    } catch(IOException e) {
                        e.printStackTrace();
                        //e.getMessage();
                        System.out.println("Probe wird abgebrochen");
                    }
                
            }
        }
    }
    
}

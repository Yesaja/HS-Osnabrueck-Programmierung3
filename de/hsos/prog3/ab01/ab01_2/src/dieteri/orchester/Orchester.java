package src.dieteri.orchester;

import java.net.URL;
import java.util.HashSet;

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

    public void proben(Orchester orchester) {
        //setzt ein Objekt vom Typ Probe für die Instanzvariable verhalten
        verhalten = new Probe();
    }

    public void auftreten(Orchester orchester) {
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

    
}

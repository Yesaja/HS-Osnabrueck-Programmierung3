package src.dieteri.orchester;

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

    public String getAudiodateiKonzert() { //laut Aufgabenblatt URL?
        return audioDateiKonzert;
    }

    public void proben(Orchester orchester) {
        //setzt ein Objekt vom Typ Probe für die Instanzvariable verhalten
    }

    public void auftreten(Orchester orchester) {
        //setzt ein Objekt vom Typ Auftritt für die Instanzvariable verhalten
    }

    public void spielen() {
        verhalten.spielen(this);
    }
}

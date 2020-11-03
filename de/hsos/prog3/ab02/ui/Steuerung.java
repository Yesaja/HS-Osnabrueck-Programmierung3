package ui;
import logik.Simulation;
import logik.BeiAenderung;
import util.EinUndAusgabe;
import util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {
 
    private Simulation sim;
    private NutzerEingabe eingabe;
    private SpielfeldDarstellung darstellung;

    public void startDesSpiels() throws InterruptedException {
        int schritt = 1; 
        initialisierung();
        int zellen = eingabe.anzahlZellenDesSpielfelds();
        int probability = eingabe.wahrscheinlichkeitDerBesiedlung();
        sim.berechneAnfangsGeneration(zellen, probability);

        while(schritt > 0){
            schritt = eingabe.anzahlDerSimulationsschitte();
            sim.berechneAnfangsGeneration(schritt, probability);
        }
    }

    public void initialisierung() {
        eingabe = new NutzerEingabe(new EinUndAusgabe());
        darstellung = new SpielfeldDarstellung(new Interaktionsbrett());
        sim.anmeldenFuerAktualisierungBeiAenderung(this);
    }

    @Override
    public void akualisiere(boolean[][] neueGeneration) {
        darstellung.abwischen();
        darstellung.spielfeldDarstellen(neueGeneration);
    }
}

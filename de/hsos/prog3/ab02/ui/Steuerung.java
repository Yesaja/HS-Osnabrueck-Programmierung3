package de.hsos.prog3.ab02.ui;
import de.hsos.prog3.ab02.logik.Simulation;
import de.hsos.prog3.ab02.logik.Simulator;
import de.hsos.prog3.ab02.logik.BeiAenderung;
import de.hsos.prog3.ab02.util.EinUndAusgabe;
import de.hsos.prog3.ab02.util.Interaktionsbrett;

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
            sim.berechneFolgeGeneration(schritt);
        }
    }

    public void initialisierung() {
        eingabe = new NutzerEingabe(new EinUndAusgabe());
        darstellung = new SpielfeldDarstellung(new Interaktionsbrett());
        sim = new Simulator();
        sim.anmeldenFuerAktualisierungBeiAenderung(this);
    }

    @Override
    public void akualisiere(boolean[][] neueGeneration) {
        darstellung.abwischen();
        darstellung.spielfeldDarstellen(neueGeneration);
    }
}

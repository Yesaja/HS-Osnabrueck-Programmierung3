package ui;
import logik.Simulation;
import logik.BeiAenderung;
import util.EinUndAusgabe;
import util.Interaktionsbrett;

public class Steuerung implements BeiAenderung{
 
    private Simulation sim;
    private NutzerEingabe eingabe;
    private SpielfeldDarstellung darstellung;

    public void startDesSpiels(){
        int schritt; 
        initialisuerng();
        int zellen = eingabe.anzahlZellenDesSpielfelds();
        int probability = eingabe.wahrscheinlichkeitDerBesiedlung();
        sim.berechneAnfangsGeneration(zellen, probability);

        while(schritt > 0){
            schritt = eingabe.anzahlDerSimulationsschitte();
            sim.berechneAnfangsGeneration(schritt);
        }

    }
    public void initialisuerng(){
        eingabe = new NutzerEingabe(new Interaktionsbrett());
        darstellung = new SpielfeldDarstellung(new EinUndAusgabe());
        sim.anmeldenFuerAktualisierungBeiAenderung(this);
        
    }
    @Override
    public  void aktualisiere(boolean[][] neueGeneration){
        darstellung.abwischen();
        darstellung.SpielfeldDarstellung(neueGeneration);
    }
}

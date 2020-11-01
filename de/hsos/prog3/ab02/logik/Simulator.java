package logik;

import java.util.Random;

public class Simulator implements Simulation {
    private boolean[][] spielfeld; //bewohnt oder unbewohnt
    private int anzahlFelder;

    @Override
    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung) {
        this.anzahlFelder = anzahlDerZellen;
        Random zufallszahl = new Random();
        for(int zeile = 0; zeile < anzahlFelder / 2; zeile++) {
            for(int spalte = 0; spalte < anzahlFelder / 2; spalte++) {
                if(wahrscheinlichkeitDerBesiedlung > zufallszahl.nextInt(101)) {
                    this.spielfeld[zeile][spalte] = true;
                } else {
                    this.spielfeld[zeile][spalte] = false;
                }
            }
        }
    }

    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) {
        // TODO Auto-generated method stub

    }

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        // TODO Auto-generated method stub

    }

}

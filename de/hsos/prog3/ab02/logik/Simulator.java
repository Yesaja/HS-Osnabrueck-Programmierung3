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
        


        for(int zeile = 0; zeile < this.anzahlFelder; zeile++) {
            for(int spalte = 0; spalte < this.anzahlFelder; spalte++) {
                boolean obenLinks = spielfeld[zeile-1][spalte-1];
                boolean obenMitte = spielfeld[zeile-1][spalte];
                boolean obenRechts = spielfeld[zeile-1][spalte+1];

                boolean mitteLinks = spielfeld[zeile][spalte-1];
                boolean mitte = spielfeld[zeile][spalte];
                boolean mitteRechts = spielfeld[zeile][spalte+1];

                boolean untenLinks = spielfeld[zeile+1][spalte-1];
                boolean untenMitte = spielfeld[zeile+1][spalte];
                boolean untenRechts = spielfeld[zeile+1][spalte+1];

            }
        }
       //1. jede bewohnte Zelle mit genau {2,3} bewohnten Nachbarn = bleibt bewohnt
       //2. jede unbewohnte Zelle mit genau {3} bewohnten Nachbarn = wird bewohnt
       //3. jede Zelle hat [3,8] Nachbarn (min=Ecke, max=Mitte)
    }

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        // TODO Auto-generated method stub

    }

}

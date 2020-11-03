package de.hsos.prog3.ab02.logik;

import java.util.Random;

public class Simulator implements Simulation {
    private boolean[][] spielfeld; //bewohnt oder unbewohnt
    private int anzahlFelder;
    private BeiAenderung beiAenderung;

    @Override
    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung) {
        this.spielfeld = new boolean[anzahlDerZellen][anzahlDerZellen];
        this.anzahlFelder = anzahlDerZellen;
        spielfeld = new boolean[anzahlDerZellen][anzahlDerZellen];
        Random zufallszahl = new Random();
        for(int zeile = 0; zeile < anzahlFelder; zeile++) {
            for(int spalte = 0; spalte < anzahlFelder; spalte++) {
                if(wahrscheinlichkeitDerBesiedlung > zufallszahl.nextInt(101)) {
                    this.spielfeld[zeile][spalte] = true;
                } else {
                    this.spielfeld[zeile][spalte] = false;
                }
            }
        }

        if(beiAenderung != null) {beiAenderung.akualisiere(spielfeld);}
    }
    
    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException { 
        int zeileLimit = spielfeld.length;
        int spalteLimit = spielfeld[0].length;
        for(int i = 0; i < berechnungsschritte; i++) {

            for(int zeile = 0; zeile < zeileLimit; zeile++) {
                for(int spalte = 0; spalte < spalteLimit; spalte++) {
                    int anzahlNachbar = berechneNachbar(zeile,spalte);

                    //regeln
                   if(anzahlNachbar >= 3 && !spielfeld[zeile][spalte]){ spielfeld[zeile][spalte] = true;}
                   if(anzahlNachbar < 2){ spielfeld[zeile][spalte] =  false;}
                   if(anzahlNachbar == 2 || anzahlNachbar == 3){ }
                   if(anzahlNachbar < 3 ){ spielfeld[zeile][spalte] =  false; }                   
                }
            }
            if(beiAenderung != null) {beiAenderung.akualisiere(spielfeld);}
            Thread.sleep(100);
        }
        

    }

    private int berechneNachbar(int x, int y){
        int nachbar = 0;
        //oben
        if(isNachbar(x-1, y-1)){nachbar++;}
        if(isNachbar(x, y-1)){nachbar++;}
        if(isNachbar(x+1, y-1)){nachbar++;}
        //mitte
        if(isNachbar(x-1, y)){nachbar++;}
        if(isNachbar(x+1, y)){nachbar++;}
        //unten
        if(isNachbar(x-1, +-1)){nachbar++;}
        if(isNachbar(x, y+1)){nachbar++;}
        if(isNachbar(x+1, y+1)){nachbar++;}
        return nachbar;
    }
    private boolean isNachbar(int x, int y){
        if(x < 0 || y < 0 || x >= spielfeld.length || y >=spielfeld[x].length){
            return false;
        }
        return spielfeld[x][y];
    }
        /*
        public void berechneFolgeGeneration(int berechnungsschritte) {
        for(int i = 0; i < berechnungsschritte; i++) {

            //Grenzen des Spielfelds festhalten
            int zeileLimit = spielfeld.length;
            int spalteLimit = spielfeld[0].length;

            for(int zeile = 0; zeile < zeileLimit-1; zeile++) {
                for(int spalte = 0; spalte < spalteLimit-1; spalte++) {

                    //Nachbarn der jeweiligen Zelle rausfinden
                    int bewohnteNachbarn = 0;

                    boolean obenLinks = spielfeld[zeile-1][spalte-1];
                    boolean obenMitte = spielfeld[zeile-1][spalte];
                    boolean obenRechts = spielfeld[zeile-1][spalte+1];

                    boolean mitteLinks = spielfeld[zeile][spalte-1];
                    boolean mitte = spielfeld[zeile][spalte]; //die Zelle selbst, weiter unten wichtig
                    boolean mitteRechts = spielfeld[zeile][spalte+1];

                    boolean untenLinks = spielfeld[zeile+1][spalte-1];
                    boolean untenMitte = spielfeld[zeile+1][spalte];
                    boolean untenRechts = spielfeld[zeile+1][spalte+1];

                    if(zeile > 1){ 				        //Zeile drüber
                        if(obenLinks) bewohnteNachbarn++;
                        if(obenMitte) bewohnteNachbarn++;
                        if(obenRechts) bewohnteNachbarn++;
                    }
                    if(zeile < zeileLimit - 1){			//Zeile drunter
                        if(untenLinks) bewohnteNachbarn++; 
                        if(untenMitte) bewohnteNachbarn++;
                        if(untenRechts) bewohnteNachbarn++;
                        
                    }
                    if(spalte > 1){				        //Spalte links
                        if(obenLinks) bewohnteNachbarn++;
                        if(mitteLinks) bewohnteNachbarn++;
                        if(untenLinks) bewohnteNachbarn++;
                    }
                    if(spalte < spalteLimit - 1){		//Spalte rechts
                        if(obenRechts) bewohnteNachbarn++;
                        if(mitteRechts) bewohnteNachbarn++;
                        if(untenRechts) bewohnteNachbarn++;
                    }

                    //Nachbarn rausgefunden, jetzt gucken, was wir damit machen

                    //Regel 1.
                    if(mitte == true && bewohnteNachbarn != 2 || bewohnteNachbarn != 3) {
                        mitte = false;
                    //Regel 2.
                    } else if(mitte == false && bewohnteNachbarn == 3) {
                        mitte = true;
                    }
                }
            }
        }
        
       //1. jede bewohnte Zelle mit genau {2,3} bewohnten Nachbarn = bleibt bewohnt
       //2. jede unbewohnte Zelle mit genau {3} bewohnten Nachbarn = wird bewohnt
       //3. jede Zelle hat [3,8] Nachbarn (min=Ecke, max=Mitte)
    }
    */

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;
    }
}

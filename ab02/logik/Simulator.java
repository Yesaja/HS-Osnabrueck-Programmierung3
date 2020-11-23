package ab02.logik;

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
        //Spielfeldgrenzen bestimmen
        int zeileLimit = spielfeld.length;
        int spalteLimit = spielfeld[0].length;
        //So viele berechnen, wie der User wuenscht
        for(int i = 0; i < berechnungsschritte; i++) {
            //Kopie des Spielfeldes anlegen
            boolean[][] spielbrett = new boolean[zeileLimit][spalteLimit];
            for(int zeile = 0; zeile < zeileLimit; zeile++) {
                for(int spalte = 0; spalte < spalteLimit; spalte++) {
                    int anzahlNachbar = berechneNachbar(zeile,spalte);

                    //1. jede bewohnte Zelle mit genau {2,3} bewohnten Nachbarn = bleibt bewohnt
                    //2. jede unbewohnte Zelle mit genau {3} bewohnten Nachbarn = wird bewohnt
                    
                    if(anzahlNachbar == 2 || anzahlNachbar == 3) {
                        spielbrett[zeile][spalte] = true;
                    } else {
                        spielbrett[zeile][spalte] = false;
                    }
                }
            }
            this.spielfeld = spielbrett;
            if(beiAenderung != null) {beiAenderung.akualisiere(spielbrett);}
            Thread.sleep(100);
        }
    }

    private int berechneNachbar(int x, int y){
        int nachbar = 0;
        //oben
        if(istNachbar(x-1, y-1))    {nachbar++;}
        if(istNachbar(x, y-1))      {nachbar++;}
        if(istNachbar(x+1, y-1))    {nachbar++;}
        //mitte
        if(istNachbar(x-1, y))      {nachbar++;}
        if(istNachbar(x+1, y))      {nachbar++;}
        //unten
        if(istNachbar(x-1, +-1))    {nachbar++;}
        if(istNachbar(x, y+1))      {nachbar++;}
        if(istNachbar(x+1, y+1))    {nachbar++;}
        return nachbar;
    }
    
    private boolean istNachbar(int x, int y){
        //innerhalb des Spielfeldes?
        if(x < 0 || y < 0 || x >= spielfeld.length || y >=spielfeld[x].length){
            return false;
        }
        
        //bewohnt oder nicht?
        if(spielfeld[x][y]) {
            return true;
        } else {
            return false;
        }
    }
 
    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;
    }
}

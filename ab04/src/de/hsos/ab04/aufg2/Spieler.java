package ab04.src.de.hsos.ab04.aufg2;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;

import java.sql.SQLOutput;

public class Spieler {

    Spielfeld spielfeld;
    Rechteck schlaeger;
    int punkte;

    public Spieler(Spielfeld m_spielfeld, int m_x, int my_y){
        spielfeld = m_spielfeld;
        schlaeger = new Rechteck(SchlaegerBreiteBerechnen(), SchlaegerHoeheBerechnen());
    }
    public int SchlaegerHoeheBerechnen(){
        return spielfeld.spielfeldflaeche.getHoehe() / 10;
    }
    public int SchlaegerBreiteBerechnen(){
        return spielfeld.spielfeldflaeche.getBreite() / 100;
    }
    public void aufwaerts(){
        if(schlaeger.oben() < spielfeld.getSpielfeldflaeche().oben()){
            System.out.println("Schlaeger nach oben");
            schlaeger.verschiebeNach(0,5);
        }
    }
    public void abwaerts(){
        if(schlaeger.unten() < spielfeld.getSpielfeldflaeche().unten()){
            System.out.println("Schlaeger nach unten");
            schlaeger.verschiebeNach(0,-5);
        }
    }
    public  void erhoehePunkte(){
        punkte++;
    }
    public  void setzePunkteZurueck(){
        punkte = 0;
    }
    public void DrawSchlaeger(Interaktionsbrett ib){
        schlaeger.darstellenFuellung(ib);
    }

}

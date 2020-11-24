package de.hsos.prog3.ab04.pong;

import de.hsos.prog3.ab04.pong.util.Interaktionsbrett;

public class Spieler {
    private Spielfeld spielfeld;
    private Rechteck schlaeger;
    private int punkte;

    public Spieler(Spielfeld spielfeld, int x, int y) {
        this.spielfeld = spielfeld;
        this.schlaeger = new Rechteck(x,y,(spielfeld.spielfeldflaeche.hoehe() / 10), (spielfeld.spielfeldflaeche.breite() / 100));
    }
    
    public void aufwaerts() {
        if(this.schlaeger.oben() > this.spielfeld.spielfeldflaeche.oben()) {
            this.schlaeger.verschiebe(0,-5);
        }
    }

    public void abwaerts() {
        if(this.schlaeger.unten() < this.spielfeld.spielfeldflaeche.unten()) {
            this.schlaeger.verschiebe(0,5);;
        }
    }

    public void erhoehePunkte() {
        this.punkte++;
    }

    public void setzePunkteZurueck() {
        this.punkte = 0;
    }

    public Rechteck getSchlaeger() {
        return this.schlaeger;
    }

    public void darstellen(Interaktionsbrett ib) {
        ib.neuesRechteck(this.getSchlaeger().links(), this.getSchlaeger().oben(), this.getSchlaeger().breite(), this.getSchlaeger().hoehe());
        for(int i = this.getSchlaeger().links(); i < this.getSchlaeger().rechts(); i++) {
            ib.neueLinie(i, this.getSchlaeger().oben(), i, this.getSchlaeger().unten());
        }
    }
}
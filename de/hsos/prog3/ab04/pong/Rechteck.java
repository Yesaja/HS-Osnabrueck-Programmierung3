package de.hsos.prog3.ab04.pong;

public class Rechteck {

    private int x;
    private int y;
    private int hoehe;
    private int breite;
    
    Rechteck(int x, int y, int hoehe, int breite) {
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public int oben() {
        return this.y;
    }

    public int unten() {
        return this.y + this.hoehe;
    }

    public int links() {
        return this.x;
    }
    
    public int rechts() {
        return this.x + this.breite;
    }

    public int breite() {
        return this.breite;
    }

    public int hoehe() {
        return this.hoehe;
    }

    public int mitteInY() {
        return this.hoehe / 2;
    }

    public int mitteInX() {
        return this.breite / 2;
    }

    public void verschiebe(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void verschiebeNach(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean ueberschneidet(Rechteck rechteck) {
        if(this.oben() > rechteck.unten() || this.unten() < rechteck.oben()) {
            return false;
        }
            
        if(this.rechts() < rechteck.links() || this.links() > rechteck.rechts()) {
            return false;
        }
        return true;
    }

}

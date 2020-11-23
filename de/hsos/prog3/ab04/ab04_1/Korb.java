package de.hsos.prog3.ab04.ab04_1;

import de.hsos.prog3.ab04.util.Interaktionsbrett;

public class Korb {

    private int x, y, seite;

    public Korb(Interaktionsbrett ib) {
        this.x = ib.zufall(10,20);
        this.y = ib.zufall(10,20);
        this.seite = 50;
    }

    public void darstellen(Interaktionsbrett ib) {
        ib.neuesRechteck(this.getX(),this.getY(),this.getSeite(),this.getSeite());
    }

    public boolean getroffen(Ball ball) {
        if( ball.getX() >= this.getX() &&
            ball.getX() <= (this.getX() + this.seite) &&
            ball.getY() >= this.getY() &&
            ball.getY() <= (this.getY() + this.seite)) {
            return true;
        }
        return false;
    }

    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getSeite() {return this.seite;}

}

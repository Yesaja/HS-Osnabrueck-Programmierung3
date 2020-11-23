package de.hsos.prog3.ab04.ab04_1;

import de.hsos.prog3.ab04.util.Interaktionsbrett;

public class Korb {

    private int x, y, seite;

    public Korb(Interaktionsbrett ib) {
        this.x = ib.zufall(10,200);
        this.y = ib.zufall(10,200);
        this.seite = 50;
    }

    public void darstellen(Interaktionsbrett ib) {
        ib.neuesRechteck(this.x,this.y,this.seite,this.seite);
    }

    public boolean getroffen(Ball ball) {
        if( ball.getX() >= this.x + ball.getRadius() &&
            ball.getX() <= this.x + this.seite - ball.getRadius() &&
            ball.getY() >= this.y + ball.getRadius() &&
            ball.getY() <= this.y + this.seite - ball.getRadius()) {
            return true;
        }
        return false;
    }
}

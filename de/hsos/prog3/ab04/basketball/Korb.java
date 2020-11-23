package de.hsos.prog3.ab04.basketball;

import de.hsos.prog3.ab04.util.Interaktionsbrett;

public class Korb {

    private int x, y, seite;

    public Korb(Interaktionsbrett ib) {
        this.x = ib.zufall(10,200);
        this.y = ib.zufall(10,200);
        this.seite = 50;
    }

    public void darstellen(Interaktionsbrett ib) {
        ib.neuesRechteck(x,y,seite,seite);
    }

    public boolean getroffen(Ball ball) {
        if(ball.getX() - ball.getRadius() > this.x && ball.getX() + ball.getRadius() < this.x + this.seite) {
            if(ball.getY() - ball.getRadius() > this.y && ball.getY() + ball.getRadius() < this.y + this.seite) {
                return true;
            }
        }
        return false;
    }
}

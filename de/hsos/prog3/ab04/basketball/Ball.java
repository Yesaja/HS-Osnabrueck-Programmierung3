package de.hsos.prog3.ab04.basketball;

import de.hsos.prog3.ab04.util.Interaktionsbrett;

public class Ball implements Listener {
    
    private int x, y, radius;
    private String name = "ball";

    public Ball(Interaktionsbrett ib) {
        this.x = ib.zufall(10,200);
        this.y = ib.zufall(10,200);
        this.radius = 10;
    }

    public void darstellen(Interaktionsbrett ib) {
        ib.neuerKreis(this,name,this.getX(),this.getY(),this.getRadius());
    }

    @Override
    public boolean mitMausVerschoben(String name, int x, int y) {
        return true;
    }

    @Override
    public boolean mitMausAngeklickt(String name, int x, int y) {
        //System.out.println("Angeklickt.");
        return true;
    }

    @Override
    public boolean mitMausLosgelassen(String name, int x, int y) {
        //System.out.println("Losgelassen.");
        this.x = x;
        this.y = y;
        return true;
    }

    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getRadius() {return this.radius;}
}

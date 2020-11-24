package de.hsos.prog3.ab04.pong;

import de.hsos.prog3.ab04.pong.util.Interaktionsbrett;

public class Ball {
    private Rechteck form;
    private int bewegungInXProFrame;
    private int bewegungInYProFrame;

    public Ball(Rechteck form, int xMove, int yMove) {
        this.form = form;
        this.bewegungInXProFrame = xMove;
        this.bewegungInYProFrame = yMove;
    }

    public void bewegen(int anzahlFrames) {
        form.verschiebe(bewegungInXProFrame, bewegungInYProFrame);
    }

    public void umkehrenDerBewegungInX() {
        bewegungInXProFrame = 0 - bewegungInXProFrame;
    }

    public void umkehrenDerBewegungInY() {
        bewegungInYProFrame = 0 - bewegungInYProFrame;
    }

    public void darstellen(Interaktionsbrett ib) {
        ib.neuesRechteck(form.links(),form.oben(),form.breite(),form.hoehe());
        for(int i = form.links(); i < form.rechts(); i++) {
            ib.neueLinie(i,form.oben(),i,form.unten());
        }
    }

    public Rechteck getForm() {
        return this.form;
    }

}

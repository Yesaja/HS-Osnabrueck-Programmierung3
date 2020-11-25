package de.hsos.prog3.ab04.pong;

import java.util.Random;

public class KollisionsDetektor {
    private Random random;
    private Spielfeld spielfeld;
    private Spieler spielerLinks;
    private Spieler spielerRechts;
    public enum BallPosition {DRINNEN, DRAUSSEN_LINKS, DRAUSSEN_RECHTS}

    public KollisionsDetektor(Spielfeld spielfeld, Spieler spieler1, Spieler spieler2) {
        this.setSpielfeld(spielfeld);
        this.setSpieler(spieler1,spieler2);
        this.random = new Random();
    }

    public void setSpielfeld(Spielfeld spielfeld) {
        if(spielfeld != null) {
            this.spielfeld = spielfeld;
        } else {
            System.out.println("Leeres Spielfeld in KollisionsDetektor uebergeben!");
            System.exit(1);
        }
    }

    public void setSpieler(Spieler spieler1, Spieler spieler2) {
        if(spieler1 != null && spieler2 != null) {
            this.spielerLinks = spieler1;
            this.spielerRechts = spieler2;
        } else {
            System.out.println("Leere Spieler an KollisionsDetektor uebergeben!");
            System.exit(1);
        }
    }

    public void checkBeruehrungBallSpielfeldGrenzen(Ball ball) {
        if(ball.getForm().oben() <= spielfeld.getSpielfeld().oben() || ball.getForm().unten() >= spielfeld.getSpielfeld().unten()) {
            ball.umkehrenDerBewegungInY();
        }
    }

    public void checkBeruehrungBallMitSchlaeger(Ball ball) {
        int seed = this.random.nextInt(100);
        if(spielerLinks.getSchlaeger().ueberschneidet(ball.getForm()) || spielerRechts.getSchlaeger().ueberschneidet(ball.getForm())) {
            if(seed < 50) {
                ball.umkehrenDerBewegungInX();
            } else {
                ball.umkehrenDerBewegungInX();
                ball.umkehrenDerBewegungInY();
            }
        }
    }

    public BallPosition checkAusserhalbDesSpielfeleds(Ball ball) {
        if(ball.getForm().rechts() < spielfeld.getSpielfeld().links()) {
            return BallPosition.DRAUSSEN_LINKS;
        }

        if(ball.getForm().links() > spielfeld.getSpielfeld().rechts()) {
            return BallPosition.DRAUSSEN_RECHTS;
        }
        return BallPosition.DRINNEN;
    }

}

package de.hsos.prog3.ab04.pong;

import de.hsos.prog3.ab04.pong.KollisionsDetektor.BallPosition;
import de.hsos.prog3.ab04.pong.util.Interaktionsbrett;

public class PongSpiel {

    private Spielfeld spielfeld;
    private Interaktionsbrett ib;
    private Spieler spielerLinks;
    private Spieler spielerRechts;
    private Ball ball;
    private KollisionsDetektor detektor;

    public final int FPMS = 17;

    public PongSpiel() {
        this.ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        startAufstellung();
    }

    private void startAufstellung() {
        this.spielfeld = new Spielfeld();
        this.spielerLinks = new Spieler(spielfeld, spielfeld.getSpielfeld().links() + 5, spielfeld.getSpielfeld().mitteInY() - 5);
        this.spielerRechts = new Spieler(spielfeld, spielfeld.getSpielfeld().rechts() - 12, spielfeld.getSpielfeld().mitteInY() - 5);
        this.ball = new Ball(new Rechteck(60,60,6,6),4,1);
        this.detektor = new KollisionsDetektor(spielfeld,spielerLinks,spielerRechts);
    }

    public void spielen() throws Exception {

        while(true) {
            Thread.sleep(FPMS);
            
            //1. Abwischen
            ib.abwischen();

            //2. Spielfeld
            spielfeld.darstellen(ib);

            //3. Spieler
            spielerLinks.darstellen(ib);
            spielerRechts.darstellen(ib);

            //4. Aktueller Spielstand
            ib.neuerText(spielfeld.getSpielfeld().mitteInX() - 100, spielfeld.getSpielfeld().oben() + 20, spielerLinks.getPunkte() + "");
            ib.neuerText(spielfeld.getSpielfeld().mitteInX() + 100, spielfeld.getSpielfeld().oben() + 20, spielerRechts.getPunkte() + "");

            //5. Ball bewegen
            ball.darstellen(ib);
            ball.bewegen(FPMS);
            
            //6. Detektor
            detektor.checkBeruehrungBallMitSchlaeger(ball);
            detektor.checkBeruehrungBallSpielfeldGrenzen(ball);
            
            BallPosition posi = detektor.checkAusserhalbDesSpielfeleds(ball);
            if(posi == BallPosition.DRAUSSEN_LINKS) {
                spielerRechts.erhoehePunkte();
                ball.umkehrenDerBewegungInX();
                ball.getForm().verschiebeNach(spielfeld.getSpielfeld().links() + 20,spielfeld.getSpielfeld().mitteInY());
            }

            if(posi == BallPosition.DRAUSSEN_RECHTS) {
                spielerLinks.erhoehePunkte();
                ball.umkehrenDerBewegungInX();
                ball.getForm().verschiebeNach(spielfeld.getSpielfeld().rechts() - 20,spielfeld.getSpielfeld().mitteInY());
            }
        }
    }

    public void tasteGedrueckt(String s) throws Exception {
        switch(s) {
            case "a":       spielerLinks.aufwaerts();
                            break;
            case "y":       spielerLinks.abwaerts();
                            break;
            case "Oben":    spielerRechts.aufwaerts();
                            break;
            case "Unten":   spielerRechts.abwaerts();
                            break;
            /*case "s":     spielen();
                            break;*/
            case "e":       System.exit(0);
        }
    }
}

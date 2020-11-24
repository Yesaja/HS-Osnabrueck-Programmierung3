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
        this.spielerLinks = new Spieler(spielfeld, spielfeld.spielfeldflaeche.links() + 5, spielfeld.spielfeldflaeche.mitteInY() - 5);
        this.spielerRechts = new Spieler(spielfeld, spielfeld.spielfeldflaeche.rechts() - 12, spielfeld.spielfeldflaeche.mitteInY() - 5);
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
            ib.neuerText(spielfeld.spielfeldflaeche.mitteInX() - 100, spielfeld.spielfeldflaeche.oben() + spielfeld.spielfeldflaeche.hoehe()+30, "Punktzahl: " + spielerLinks.getPunkte() + "");
            ib.neuerText(spielfeld.spielfeldflaeche.mitteInX() + 100, spielfeld.spielfeldflaeche.oben() + spielfeld.spielfeldflaeche.hoehe()+30, spielerRechts.getPunkte() + "");

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
                ball.getForm().verschiebeNach(spielfeld.spielfeldflaeche.links() + 30,spielfeld.spielfeldflaeche.mitteInY());
            }
            if(posi == BallPosition.DRAUSSEN_RECHTS) {
                spielerLinks.erhoehePunkte();
                ball.umkehrenDerBewegungInX();
                ball.getForm().verschiebeNach(spielfeld.spielfeldflaeche.rechts() - 80,spielfeld.spielfeldflaeche.mitteInY());
            }
        }
    }

    public void tasteGedrueckt(String s) throws Exception {
        switch(s) {
            case "a":       spielerLinks.aufwaerts();
                            break;
            case "y":       spielerLinks.abwaerts();
                            break;
            case "j":       spielerRechts.aufwaerts();
                            break;
            case "m":       spielerRechts.abwaerts();
                            break;
            /*case "s":       spielen();
                            break;*/
            case "e":       System.exit(0);
        }
    }

}

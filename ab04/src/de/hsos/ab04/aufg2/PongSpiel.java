package ab04.src.de.hsos.ab04.aufg2;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;

public class PongSpiel {
    final int FPMS = 17;
    Spielfeld spielfeld;

    Ball ball;

    Spieler spielerLinks;
    Spieler spielerRechts;

    Interaktionsbrett ib;


    public PongSpiel(){
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        startAustellung();
        initialeAufstellung();
    }


    private void startAustellung(){
        spielfeld = new Spielfeld();
        spielerLinks = new Spieler(spielfeld, 10, 5);
        spielerRechts = new Spieler(spielfeld, 50, 5);
    }

    //TODO: muss noch angepasst und überarbeitet weden. Nach ange von Aufg2.6
    private void initialeAufstellung(){
        Rechteck b = new Rechteck(spielerLinks.schlaeger.mitteInX() + 10 ,spielerLinks.schlaeger.mitteInY() ,5,5);
        ball = new Ball(b,4,1);
    }

    public void spielen(){
        int differenz = 0;

            while (true) {
               // Thread.sleep(System.currentTimeMillis() / FPMS);
                ib.abwischen();
                ball.darstellen(ib);
                ball.bewegen((int) System.currentTimeMillis() / FPMS);
                spielfeld.darstellen(ib);
                spielerLinks.DrawSchlaeger(ib);
                spielerRechts.DrawSchlaeger(ib);
                differenz = (int) System.currentTimeMillis();
            }

    }
    public void tasteGedrueckt(String s){
        switch (s){
            case "a":
                spielerLinks.aufwaerts();
                break;
            case "y":
                spielerLinks.abwaerts();
                break;
            case "Oben" :
                spielerRechts.aufwaerts();
                break;
            case "Unten" :
                spielerLinks.abwaerts();
                break;
            case "s" :
                spielen();
                break;
            case "e":
                System.exit(1);
            default:
                 break;
        }
    }

    
}

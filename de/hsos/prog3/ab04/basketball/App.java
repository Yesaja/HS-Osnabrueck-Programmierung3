package de.hsos.prog3.ab04.basketball;

import de.hsos.prog3.ab04.util.Interaktionsbrett;

public class App {
    public static void main(String[] args) {
        
        int i = 0;
        Interaktionsbrett spielfeld = new Interaktionsbrett();

        while(i < 3) {
            try {
                spielstart(spielfeld);
                ++i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.exit(0);
    }

    public static void spielstart(Interaktionsbrett spielfeld) throws Exception {
        long start, stop;

        Ball ball = new Ball(spielfeld);
        Korb korb = new Korb(spielfeld);        

        spielfeld.abwischen();
        ball.darstellen(spielfeld);
        korb.darstellen(spielfeld);

        start = System.currentTimeMillis();

        while(!korb.getroffen(ball)) {
            Thread.sleep(100);
        }
        
        System.out.println("Treffer!");
        stop = System.currentTimeMillis() - start;
        spielfeld.neuerText(15,15,"Benötigte Zeit: " + stop + "ms");
        Thread.sleep(3000);
    }
}

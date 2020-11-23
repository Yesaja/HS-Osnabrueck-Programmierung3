package de.hsos.prog3.ab04.ab04_1;

import de.hsos.prog3.ab04.util.Interaktionsbrett;

public class App {
    public static void main(String[] args) {
        
        Interaktionsbrett spielfeld = new Interaktionsbrett();

        Ball ball = new Ball(spielfeld);
        Korb korb = new Korb(spielfeld);        

        ball.darstellen(spielfeld);
        korb.darstellen(spielfeld);

        spielfeld.starteUhr();

        while(true) {
            if(korb.getroffen(ball)) {
                System.out.println("Treffer!");
            } else {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
    
                }
            }
        }
    }
}

package ab04.src.de.hsos.ab04;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;
//fuer aufgabe1
import ab04.src.de.hsos.ab04.aufg1.Ball;
import ab04.src.de.hsos.ab04.aufg1.Korb;
//fuer aufgabe2
import ab04.src.de.hsos.ab04.aufg2.PongSpiel;

public class App {

    public static void main(String[] args) {
	// write your code here

        PongSpiel spiel = new PongSpiel();
        spiel.spielen();

        /*
        Ball b = new Ball();
        Korb k = new Korb();
        b.darstellen(ib);
        k.darstellen(ib);

*/


    }
}

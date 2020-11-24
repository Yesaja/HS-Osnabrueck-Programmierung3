package de.hsos.prog3.ab04.pong;

//import de.hsos.prog3.ab04.pong.util.Interaktionsbrett;

public class App {
    public static void main(String[] args) {
        try {
            PongSpiel spiel = new PongSpiel();
            spiel.spielen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

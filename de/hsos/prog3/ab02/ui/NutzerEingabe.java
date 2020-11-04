package de.hsos.prog3.ab02.ui;
import de.hsos.prog3.ab02.util.EinUndAusgabe;

public class NutzerEingabe {
    
    final int MIN_SPIELFELD = 10;
    final int MIN_SIMULATIONSCHRITTE = 10;
    private EinUndAusgabe io;

    public NutzerEingabe(EinUndAusgabe io){
        this.io = io;
    }
    public int anzahlZellenDesSpielfelds(){
        int eingabe;
        String exept; 
        boolean x = false; 
        do {
            System.out.println("Bitte geben Sie die Anzahl der Zellen des Spielfeldes an");
            eingabe = io.leseInteger();
            if(eingabe>=MIN_SPIELFELD) {
                System.out.println("Bitte bestätigen Sie die Eingabe von: " + eingabe + " (y) / (n)" );
                exept = io.leseString();
                if(exept.equals("y")) {
                    return eingabe; 
                } else {
                    x = true;
                }
            } else {
                System.out.println("Die eingegebene Zahl liegt under der Mindestzahl von " + MIN_SPIELFELD);
                System.out.println("Soll die Mindestanzahl genutzt werden? (y) / (n)" );
                    exept = io.leseString();
                    if(exept.equals("y")) {
                        return MIN_SPIELFELD; 
                    } else {
                        x = true;
                    }
            }
        } while(x);
        return -1; // Fehler, sollte nie erreicht werden
    }
    public int wahrscheinlichkeitDerBesiedlung(){
        int eingabe; 
        boolean x = false; 
        do {
            System.out.println("Geben Sie eine Prozentzahl zwischen 1 und 100 für die Besiedlung an: ");
            eingabe = io.leseInteger();
            if(eingabe >= 1 && eingabe <= 100){
                return eingabe;
            } else {
                x = true;
            }
        } while(x);
        return -1; // Fehler, sollte nie erreicht werden
    }

    public int anzahlDerSimulationsschitte(){
        int eingabe; 
        boolean x = false;
        do {
            System.out.println( "Geben Sie die Anzahl der Simulationsschritte an, \n" +
                                "Sie koennen waehrend der Berechnung nicht mit dem Programm interagieren.");
            eingabe = io.leseInteger();
            if(eingabe >= 1){
                return eingabe;
            } else if(eingabe < 1) {
                System.out.println("Simulation wird beendet.");
                return 0;
            } else {
                x = true;
            }
        } while(x);
        return -1; // Fehler, sollte nie erreicht werden
    }
}

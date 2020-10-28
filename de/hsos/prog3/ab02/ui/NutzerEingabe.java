package ab02.ui;
import ab02.util.EinUndAusgabe;

public class NutzerEingabe {
    
    final int MIN_SPIELFELD = 10;
    final int MIN_SIMULATIONSCHRITTE = 10;
    private EinUndAusgabe io;

    NutzerEingabe(EinUndAusgabe io){
        this.io = io;
    }
    public int anzahlZellenDesSpielfelds(){
        int eingabe;
        String exept; 
        boolean x = false; 
        do{
            System.out.println("Bitte geben sie die anzahl der Zellen des Spielfeildes an");
            eingabe = io.leseInteger();
            if(eingabe>=MIN_SPIELFELD){
                System.out.println("Bitte bestätigen sie die eingabe von: " + eingabe + " (y) / (n)" );
                exept = io.leseString();
                if(exept == "y"){
                    return eingabe; 
                }else{
                    x = true;
                }
            }else{
                System.out.println("Die Eingegebene Zahl liegt under der mindestzahl von " + MIN_SPIELFELD);
                System.out.println("Soll die mindestanzal genutzt werden? (y) / (n)" );
                    exept = io.leseString();
                    if(exept == "y"){
                        return MIN_SPIELFELD; 
                    }else{
                        x = true;
                    }
            }
        }while(x);
        
    }
    public int wahrscheinlichkeitDerBesiedlung(){
        int eingabe; 
        boolean x = false; 
        do{
            System.out.println("Geben sie eine prozentzahl ziwschen 1 und 100 an für die Besiedlung");
            eingabe = io.leseInteger();
            if(eingabe >= 1 && eingabe >= 100){
                return eingabe;
            }else{
                x = true;
            }
        }while(x);

    }
    public int anzahlDerSimulationsschitte(){
        int eingabe; 
        boolean x = false;
        do{
            System.out.println( "Geben sie die anzahl der Simulationsschritte an, \n" +
                                "sie koennen waerend der berechnung nicht mit dem programm interagieren.");
            eingabe = io.leseInteger();
            if(eingabe > 1){
                return eingabe;
            }else{
                x = true;
            }
        }while(x);
    }
}

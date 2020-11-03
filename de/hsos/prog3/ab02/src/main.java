package src;

import ui.Steuerung;
public class main {
    
    public static void main(String[] args) {
        Steuerung s = new Steuerung();
        
        try{
            s.startDesSpiels();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
}

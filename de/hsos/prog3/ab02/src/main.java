package de.hsos.prog3.ab02.src;

import ui.Steuerung;
public class Main {
    
    public static void main(String[] args) {
        Steuerung s = new Steuerung();
        
        try{
            s.startDesSpiels();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
}

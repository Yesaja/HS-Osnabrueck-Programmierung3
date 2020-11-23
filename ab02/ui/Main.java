package ab02.ui;

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

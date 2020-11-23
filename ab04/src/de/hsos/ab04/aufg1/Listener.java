package ab04.src.de.hsos.ab04.aufg1;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;

public class Listener {

    Listener(){
    }

    public Boolean mitMausVerschoben(String name, int x, int y){
        System.out.println("mitMausVerschoben");
        return true;
    }
    public Boolean mitMausAngeklickt(String name, int x, int y){
        System.out.println("mitMausAngeklickt");

        return true;
    }
    public Boolean mitMausLosgelassen(String name, int x, int y){
        System.out.println("mitMausLosgelassen");
        return true;
    }


}

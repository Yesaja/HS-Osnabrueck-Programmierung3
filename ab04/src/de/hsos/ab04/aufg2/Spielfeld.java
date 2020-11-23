package ab04.src.de.hsos.ab04.aufg2;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;

public class Spielfeld {

    public Rechteck spielfeldflaeche;

    public Spielfeld(){
        spielfeldflaeche = new Rechteck(300,500);
    }
    public Rechteck getSpielfeldflaeche(){
        return spielfeldflaeche;
    }
    public void darstellen(Interaktionsbrett ib){
        spielfeldflaeche.darstellenRahmen(ib);
    }

}

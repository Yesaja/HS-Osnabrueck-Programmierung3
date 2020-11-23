package ab02.ui;

import ab02.util.Interaktionsbrett;

public class Quadrat {
    
    private int x; 
    private int y; 
    private int seitenlaenge;

    Quadrat(int x, int y, int seitenlaenge){
        setX(x);
        setY(y);
        setSeitenlaenge(seitenlaenge);
    };

   public void setX(int x) {
        if(x < 5){
            this.x = 5;
        }
        this.x = x;
    }
    public void setY(int y) {
        if(y < 5){
            this.y = 5;
        }
        this.y = y;
    }

    public void setSeitenlaenge(int seitenlaenge) {
        if(seitenlaenge < 50){
            this.seitenlaenge = 50;
        }
        this.seitenlaenge = seitenlaenge;
    }

    public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(x,y,seitenlaenge,seitenlaenge);
    }
    public void darstellenFuellung(Interaktionsbrett ib){
        ib.neuesRechteck(x,y,seitenlaenge,seitenlaenge);
        for(int i = 0; i < seitenlaenge ; i++){
            ib.neueLinie(x,y+i,x+seitenlaenge,y+i);
        }      
    }
}

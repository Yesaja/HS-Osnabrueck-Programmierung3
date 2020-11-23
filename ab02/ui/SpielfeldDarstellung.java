package ab02.ui;

import ab02.util.Interaktionsbrett;

class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    private final int SEITENLAENGE_SPIELFELD = 300;
    private final int MARGIN = 10;
    
    SpielfeldDarstellung(Interaktionsbrett ib) {
        this.ib = ib;
    }

    public void spielfeldDarstellen(boolean[][] spielfeld) {
        int seitenlaenge = SEITENLAENGE_SPIELFELD / spielfeld.length;
        int x = MARGIN; 
        int y = MARGIN;
        for(boolean[] a : spielfeld) {
            for(boolean b : a) {
                Quadrat quadrat = new Quadrat(x,y,seitenlaenge);
                if(b) quadrat.darstellenFuellung(ib);
                else quadrat.darstellenRahmen(ib);
                
                x += seitenlaenge;
            }
            x = MARGIN;
            y += seitenlaenge;
        }
    }

    public void abwischen() {
        ib.abwischen();
    };
}
package ab04.src.de.hsos.ab04.aufg2;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;

public class Rechteck {

    private int x;
    private int y;
    private int hoehe;
    private int breite;
    Rechteck(int m_x, int m_y, int m_hoehe, int m_breite) {
            setX(x);
            setY(y);
            setHoehe(m_hoehe);
            setBreite(m_breite);
    }
    Rechteck(int m_hoehe, int m_breite) {
        setX(5);
        setY(5);
        setHoehe(m_hoehe);
        setBreite(m_breite);
    }

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public void setHoehe(int m_hoehe) {
           this.hoehe = (m_hoehe < 50) ? 50 : m_hoehe;
    }

    public void setBreite(int m_breite) {
        this.breite  = (m_breite < 50) ? 50 : m_breite;
    }

    public int oben(){
            return getY();
    }
    public int unten(){
            return getY() + getHoehe();
    }
    public int rechts(){
            return getX() + getBreite();
    }
    public int links(){
            return getX();
    }
    public int breite(){
            return getBreite();
    }
    public int hoehe(){
            return getHoehe();
    }
    public int mitteInY(){

            return hoehe/2;
    }
    public int mitteInX(){
            return breite/2;
    }
    public void verschiebe(int dx, int dy){
            setX(this.x + dx);
            setY(this.y + dy);
    }
    public void verschiebeNach(int x, int y){
            setX(x);
            setY(y);
    }
    public boolean ueberschneidet(Rechteck o){
        if(this.oben() < o.unten() || this.unten() > o.oben())
            return false;
        if(this.oben() < o.unten()|| this.unten() > o.oben())
            return false;
        return true;
    }
   public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(x,y,breite,hoehe);
   }
   public void darstellenFuellung(Interaktionsbrett ib){
    ib.neuesRechteck(x,y,hoehe,breite);
        for(int i = 0; i < breite ; i++){
            ib.neueLinie(x,y+i,x+hoehe,y+i);
        }
    }
}

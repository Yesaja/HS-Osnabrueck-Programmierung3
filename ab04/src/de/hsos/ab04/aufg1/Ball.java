package ab04.src.de.hsos.ab04.aufg1;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;

public class Ball extends Listener{
    private int x;
    private int y;
    private int radius;
    public String name = "ball-event";
    public Ball(){
        super();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void darstellen(Interaktionsbrett ib){
        setX(ib.zufall(10, 100));
        setY(ib.zufall(10, 100));
        setRadius(10);

        ib.neuerKreis(this,name,x,y, radius);
    }

}

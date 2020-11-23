package ab01.ab01_1.src.dieteri.ab01;

import java.util.Objects;

public class Nachbar{
    private String vorname;
    private String nachname;

    public Nachbar(String v, String n){
        setVorname(v);
        setNachname(n);
    }

    String getVorname(){ return vorname; }
    void setVorname(String v){ vorname = v;}

    String getNachname(){ return nachname; }
    void setNachname(String n){ nachname = n; }

    @Override
    public int hashCode() {
        return Objects.hash(vorname, nachname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nachbar nachbar = (Nachbar) o;
        return vorname.equals(nachbar.vorname) &&
                nachname.equals(nachbar.nachname);
    }

    @Override
    public String toString(){
        return getVorname() + " " + getNachname();
    }
}

package logik;

public interface Simulation {
    void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlihckeitDerBesiedlung);
    void berechneFolgeGeneration(int berechnungsschritte);
    void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAnederung);
}
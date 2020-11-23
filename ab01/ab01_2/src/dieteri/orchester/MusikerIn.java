package ab01.ab01_2.src.dieteri.orchester;

public class MusikerIn extends Mitglied {
    
    private Instrument instrument;

    public MusikerIn(String name, Instrument instrument) {
        super(name);
        this.instrument = instrument;
    }

    public Instrument getInstrument() {
        return this.instrument;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MusikerIn other = (MusikerIn) obj;
        if (this.instrument != other.instrument && this.getName() != other.getName())
            return false;
        return true;
    }
}

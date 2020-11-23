package ab01.ab01_2.src.dieteri.orchester;

public abstract class Mitglied {
    private String name;

    public Mitglied(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

package src.dieteri.orchester;

enum Instrument {
    SAXOPHON("Baritone.wav"), SCHLAGZEUG("Drum.wav"), AKKORDION("Accordeon.wav");
    private String audiodatei;

    Instrument(String audiodatei) {
        this.audiodatei = audiodatei;
    }

    public String getAudio() {
        return this.audiodatei;
    }
}
package ab01.ab01_2.src.dieteri.orchester;

enum Instrument {
    SAXOPHON("/res/Baritone.wav"), SCHLAGZEUG("/res/Drum.wav"), AKKORDION("/res/Accordion.wav");
    private String audiodatei;

    Instrument(String audiodatei) {
        this.audiodatei = audiodatei;
    }

    public String getAudio() {
        return this.audiodatei;
    }
}
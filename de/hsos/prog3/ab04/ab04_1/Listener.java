package de.hsos.prog3.ab04.ab04_1;

public interface Listener {
    public boolean mitMausVerschoben(String name, int x, int y);
    public boolean mitMausAngeklickt(String name, int x, int y);
    public boolean mitMausLosgelassen(String name, int x, int y);
}

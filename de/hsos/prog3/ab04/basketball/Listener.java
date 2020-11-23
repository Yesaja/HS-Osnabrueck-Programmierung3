package de.hsos.prog3.ab04.basketball;

public interface Listener {
    public boolean mitMausVerschoben(String name, int x, int y);
    public boolean mitMausAngeklickt(String name, int x, int y);
    public boolean mitMausLosgelassen(String name, int x, int y);
}

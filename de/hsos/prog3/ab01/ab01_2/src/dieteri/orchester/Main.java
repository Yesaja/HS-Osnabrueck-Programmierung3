package src.dieteri.orchester;

import java.io.IOException;
import java.net.URL;

//import org.graalvm.compiler.asm.aarch64.AArch64Assembler.Instruction;

public class Main {
    public static void main(String[] args) throws IOException {
        String audioDatei = "/All_Together.wav";
        Orchester orchester = new Orchester("HSOS Nipple Twister Orchestra", audioDatei);
        DirigentIn Rosmann = new DirigentIn("Rosmann");

        MusikerIn trompete = new MusikerIn("Susi Sorglos", Instrument.SAXOPHON);
        MusikerIn akkordion = new MusikerIn("Akki Taste", Instrument.AKKORDION);
        MusikerIn drum = new MusikerIn("Speider Swen", Instrument.SCHLAGZEUG);
        
        orchester.addDirigentIn(Rosmann);
        orchester.addMusikerIn(trompete);
        orchester.addMusikerIn(akkordion);
        orchester.addMusikerIn(drum);

        orchester.proben(orchester);
        orchester.auftreten(orchester);

        try{ 
            orchester.spielen();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

/**
import de.hsos.prog3.audio.SimpleAudioPlayer;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
	    URL url = Main.class.getResource("/res/Drum.wav");
        SimpleAudioPlayer player = new SimpleAudioPlayer(url);
        player.setDebug(false);
        player.verboseLogging(true);
        player.play(0);
    }
}
*/
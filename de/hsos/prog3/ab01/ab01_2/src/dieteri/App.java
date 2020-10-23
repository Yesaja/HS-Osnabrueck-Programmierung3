import java.io.IOException;
import java.net.URL;

import org.graalvm.compiler.asm.aarch64.AArch64Assembler.Instruction;

import de.hsos.prog3.audio.SimpleAudioPlayer;
import src.dieteri.orchester.DirigentIn;
import src.dieteri.orchester.MusikerIn;
import src.dieteri.orchester.Orchester;

public class App {
    public static void main(String[] args) throws IOException {
        String audioDatei = "/All_Together.wav";
        Orchester orchester = new Orchester("HSOS Nipple Twister Orchestra", audioDatei);
        DirigentIn Rosmann = new DirigentIn("Rosmann");

        MusikerIn trompete = new MusikerIn("Susi Sorglos", Instrument.SAXOPHON);
        MusikerIn akkordion = new MusikerIn("Akki Taste", Instrument.AKKORDION);
        MusikerIn drum = new MusikerIn("Speider Swen", Instruction.SCHLAGZEUG);
        
        orchester.addDirigentIn(Rosmann);
        orchester.addMusikerIn(trompete);
        orchester.addMusikerIn(akkordion);
        orchester.addMusikerIn(drum);

        orchester.proben(orchester);
        orchester.konzert(orchester);

        try{ 
            orchester.spielen();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
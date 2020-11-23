package ab01.ab01_1.src.dieteri.ab01;

import java.util.Iterator;
import java.util.HashSet;


public class App {

    public static void main(String[] args) {
        Nachbar luck = new Nachbar("Luck", "Skywarker");
        Nachbar luck2 = new Nachbar("Luck", "Skywarker");
        Nachbar finn = new Nachbar("Finn", "Reinhardt");
        Nachbar leon = new Nachbar("Leron", "Pille");
        HashSet<Nachbar> h = new HashSet<Nachbar>();
        h.add(luck);
        h.add(luck2);
        h.add(finn);
        h.add(leon);

        Iterator itr = h.iterator();

        System.out.println("HashSet contains : ");
        while(itr.hasNext())
            System.out.println("Moin Moin " + itr.next());
    }
}

package ab01.ab01_1.src.stwaschk;

import java.util.HashSet;

public class App {

	public static void main(String[] args) {
		HashSet<Nachbar> set = new HashSet<Nachbar>();
		Nachbar finn = new Nachbar("Finn","Reinhardt");
		Nachbar paul = new Nachbar("Paul", "Dieterich");
		Nachbar paul2 = new Nachbar("Paul", "Dieterich");
		set.add(finn);
		set.add(paul);
		set.add(paul2);
		set.add(finn);
		System.out.println("Hallo " + set.toString());
	}

}
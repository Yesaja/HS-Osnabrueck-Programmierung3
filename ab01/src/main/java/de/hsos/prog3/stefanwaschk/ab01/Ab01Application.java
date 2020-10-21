package de.hsos.prog3.stefanwaschk.ab01;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.java.de.hsos.prog3.stefanwaschk.ab01.Nachbar;
import java.util.HashSet;

public class Ab01Application {

	public static void main(String[] args) {
		//SpringApplication.run(Ab01Application.class, args);
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
package de.hsos.prog3.ab03.src;

/*
import java.util.*;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
*/

public class Main {

    public static void main(String[] args) {

        Ringpuffer<String> FiFo = new Ringpuffer<>();
        //String s = "INIT";
        //FiFo.
        String a = "Object_1";
        String b = "Object_2";
        String c = "Object_3";
        String d = "Object_4";
        String e = "Object_5";

        FiFo.add(a);
        System.out.println("Elements "+FiFo.toString() + "\n");
        FiFo.add(b);
        System.out.println("Elements "+FiFo.toString() + "\n");
        FiFo.add(c);
        System.out.println("Elements "+FiFo.toString() + "\n");
        FiFo.add(d);
        System.out.println("Elements "+FiFo.toString() + "\n");
        FiFo.add(e);
        System.out.println("Elements "+FiFo.toString() + "\n");

        System.out.println("Ringpuffer-Funktion: Peek() " + FiFo.peek());
        System.out.println("Elements "+FiFo.toString() + "\n");
        System.out.println("Ringpuffer-Funktion: Peek() " + FiFo.peek());
        System.out.println("Elements "+FiFo.toString() + "\n");
        System.out.println("Ringpuffer-Funktion: Peek() " + FiFo.peek());
        System.out.println("Elements "+FiFo.toString() + "\n");

        //String neu = "neuerString";

        System.out.println("Ringpuffer-Funktion: Element() " + FiFo.element());
        System.out.println("Elements "+FiFo.toString() + "\n");

        System.out.println("Ringpuffer-Funktion: Remove() " + FiFo.remove());
        System.out.println("Elements "+FiFo.toString() + "\n");
        System.out.println("Ringpuffer-Funktion: Remove() " + FiFo.remove());
        System.out.println("Elements "+FiFo.toString() + "\n");
        System.out.println("Ringpuffer-Funktion: Remove() " + FiFo.remove());
        System.out.println("Elements "+FiFo.toString() + "\n");

        System.out.println("Ringpuffer-Funktion: Element() " + FiFo.element());
        System.out.println("Elements "+FiFo.toString() + "\n");

        System.out.println("Ringpuffer-Funktion: Poll() " + FiFo.poll());
        System.out.println("Elements "+FiFo.toString() + "\n");
        System.out.println("Ringpuffer-Funktion: Poll() " + FiFo.poll());
        System.out.println("Elements "+FiFo.toString() + "\n");
        System.out.println("Ringpuffer-Funktion: Poll() " + FiFo.poll());
        System.out.println("Elements "+FiFo.toString() + "\n");
    }
}

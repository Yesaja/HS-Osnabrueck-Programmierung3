package de.hsos.prog3.ab03.src;

import java.io.Serializable;
//import java.lang.reflect.Array;
import java.util.*;

public class Ringpuffer<T> implements Queue<T>, Serializable, Cloneable {

    ArrayList<T> elements;
    private int writePos = 0;
    private int readPos = 0;
    private int size;
    private int capacity;
    private boolean fixedCapacity;
    private boolean discarding;
    private int factor;

    Ringpuffer() {
        this.capacity = initialize(0);
        elements = new ArrayList<T>(capacity);
    }

    //User defines the capacity of the Ring Buffer
    private int initialize(int min) {
        EinUndAusgabe input = new EinUndAusgabe();
        do {

            System.out.print("Bitte gib die maximale Kapazität ein: ");
            capacity = input.leseInteger();
        } while (capacity < min + 1);
        if (!discarding && fixedCapacity) {
            writePos -= capacity - min;
        }
        System.out.println("Die maximale Anzahl der Elemente im Ringpuffer beträgt " + capacity + "\n");

        System.out.println("Wie soll sich der Ringpuffer verhalten, wenn es zu einem Überlauf kommt?");
        int prompt;
        do {
            System.out.println("Bitte wählen Sie eine der folgenden Optionen für zukünftige Elemente aus:\n");

            System.out.println("(1) Das älteste Element im Speicher wird überschrieben");
            System.out.println("(2) Die Kapazität wird um einen Faktor erhöht");
            System.out.println("(3) Es werden keine neuen Elemente mehr hinzugefügt");
            prompt = input.leseInteger();
        } while (prompt != 1 && prompt != 2 && prompt != 3);

        switch (prompt) {
            case 1:
                //Elemente dürfen überschrieben werden, Ringpuffer bleibt statisch
                discarding = true;
                fixedCapacity = true;
                System.out.println("Zukünftige Elemente werden in Abhängigkeit von der Aktualität überschrieben\n");
                break;
            case 2:
                //Der Ringpuffer wird erweitert, Elemente werden nicht überschrieben
                discarding = false;
                fixedCapacity = false;
                System.out.println("Bitte geben sie den Faktor an, um den der Ringpuffer vergrößert werden soll:");
                factor = input.leseInteger();
                System.out.println("Der Ringpuffer wird bei Überläufen um den Faktor " + factor + " erweitert\n");
                break;
            case 3:
                //Es dürfen keine Elemente mehr hinzugefügt werden
                discarding = false;
                fixedCapacity = true;
                System.out.println("Es werden keine Elemente mehr hinzugefügt\n");
                break;
            default:
                break;
        }

        return capacity;
    }

    private void setCapacity(int capacity) {
        if (!fixedCapacity) {
            this.capacity = capacity;
        }
    }

    public void incrementWritePos() {
        if (inRange(writePos + 1)) {
            this.writePos = writePos + 1;
        } else {
            //Überlauf des Schreibzeigers
            this.writePos = 0;
        }
    }

    public void decrementWritePos() {
        if (inRange(writePos - 1)) {
            this.writePos = writePos - 1;
        } else {
            //Überlauf des Schreibzeigers
            this.writePos = capacity - 1;
        }
    }

    public void incrementReadPos() {
        if (inRange(readPos + 1)) {
            this.readPos = readPos + 1;
        } else {
            //Überlauf des Lesezeigers
            this.readPos = 0;
        }
    }

    public boolean inRange(int position) {
        //Incrementing the Counter needs to reset it
        if (0 == (position % capacity)) {
            return false;
        }
        return true;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFixedCapacity(boolean fixedCapacity) {
        this.fixedCapacity = fixedCapacity;
    }

    public void setDiscarding(boolean discarding) {
        this.discarding = discarding;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        //Lesezeiger ist vor Schreibzeiger
        if (writePos < readPos) {
            //Durchlaufen der rechten Hälfte
            for (int i = readPos; i < capacity - 1; i++) {
                if (elements.equals(o)) {
                    return true;
                }
            }
            //Durchlaufen der rechten Hälfte
            for (int i = 0; i < writePos; i++) {
                if (elements.equals(o)) {
                    return true;
                }
            }
            //Schreibzeiger ist vor Lesezeiger
        } else {
            for (int i = 0; i < writePos; i++) {
                if (elements.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public String toString() {
        return elements.toString();
    }

    @Override
    public boolean add(T t) {
        EinUndAusgabe input = new EinUndAusgabe();
        //Kapazität ist ausgeschoepft
        if (size == capacity) {
            System.out.println("Der Ringpuffer ist voll");
            //Elemente überschreiben
            if (discarding && fixedCapacity) {
                System.out.println("Vorhandene Elemente werden basierend auf Ihrer Aktualität überschrieben");
                elements.set(writePos, t);
                if (readPos == writePos) {
                    incrementReadPos();
                }
                incrementWritePos();

                //Ringpuffer wird erweitert
            } else if (!discarding && !fixedCapacity) {
                System.out.println("Die Kapazität des Ringpuffers wird um " + factor + " Stelle(n) erweitert\n");
                setCapacity(capacity + factor);
                //writePos = capacity;
                this.add(t);

                //Es werden keine Elemente mehr hinzugefügt
            } else if (!discarding && fixedCapacity) {
                System.out.println("Es werden keine weiteren Elemente mehr hinzugefügt. Möchten sie dies ändern? Dann wiederholen sie bitte die Initialisierung:(Y)/(N)");
                char answer = input.leseString().charAt(0);
                switch (answer) {
                    case 'y':
                        System.out.println("Die erneute Initialisierung beginnt");
                        initialize(capacity);
                        this.add(t);
                        break;
                    case 'n':
                        System.out.println("Das Element wurde nicht hinzugefügt");
                        break;
                }
            }
            return false;
        } else {
            //Es ist noch Kapazität vorhanden. Size < Capacity
            elements.add(t);
            System.out.println("Das Element " + t.toString() + " wurde erfolgreich hinzugefügt.");
            //Erhöhen der eigentlichen Elemente und Schreibposition
            incrementWritePos();
            size++;
            return true;
        }
    }

    private void fillRingBuffer(T t) {
        for (int i = 0; i < capacity; i++) {
            elements.add(t);
        }
    }

    public int getWritePos() {
        return writePos;
    }

    public int getReadPos() {
        return readPos;
    }

    //Methode nicht implementiert, da Ringpuffer keine "Lücken" zulässt
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            this.add(t);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    //removes all elements
    @Override
    public void clear() {
        for (int i = 0; i < capacity - size - 1; i++) {
            elements.remove(i);
        }
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    /**
     * @Removes Head Object by decrementing the write position
     * Objects are not "removed", but marked to be overwritten
     */

    @Override
    public T remove() throws NoSuchElementException {
        if (size > 0) {
            return obliterate();
        }
        throw new NoSuchElementException("Der Ringpuffer ist leer");
    }

    /**
     * Retrieves and removes the head of the Ringbuffer
     */
    @Override
    public T poll() {
        if (size > 0) {
            return obliterate();
        }
        return null;
    }

    /**
     * Retrieves the head of the Ringbuffer
     * Throws Exception
     */
    @Override
    public T element() throws NoSuchElementException {
        if (size > 0) {
            T temp = elements.get(readPos);
            return temp;
        }
        throw new NoSuchElementException("Der Ringpuffer ist leer");
    }

    /**
     * Retrieves the head of the Ringbuffer
     */
    @Override
    public T peek() {
        if (size > 0) {
            T temp = elements.get(readPos);
            return temp;
        }
        return null;
    }

    private T obliterate() {
        T temp = elements.get(readPos);
        elements.remove(readPos);
        if (!(readPos == 0)) {
            incrementReadPos();
        }
        size--;
        return temp;
    }
}

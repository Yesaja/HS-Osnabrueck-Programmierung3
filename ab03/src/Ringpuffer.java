/*package ab03.src;


import java.io.Serializable;
import java.util.*;

public class Ringpuffer<T> implements Queue<T>, Serializable, Cloneable {

    private static class RingpufferInterator<E> implements Iterator<E>{
        Ringpuffer<E> ringpuffer;
        boolean first;
        public RingpufferInterator(Ringpuffer<E> ringpuffer, boolean first){
            this.ringpuffer = (Ringpuffer<E>) ringpuffer.clone();  //TODO: wie geht das richig?
            this.first = first;
        }

        @Override
        public boolean hasNext() {
            return !ringpuffer.isEmpty();
        }

        @Override
        public E next() {
            //TODO: ringpuffer.poll wird nur zurucek gegeben damit es kein error gibt, muss noch koreet implmementiert werden.
            return ringpuffer.poll();
        }
    }

    private ArrayList<T> elements;
    private int writePos;
    private int readPos;
    private int size;
    private int capacity;
    private boolean fixedCpacity;
    private boolean discarding;

    Ringpuffer(int m_capacity,boolean m_fixedCpacity,boolean m_discarding){
        this.capacity = m_capacity;
        this.fixedCpacity = m_fixedCpacity;
        this.discarding = m_discarding;

        elements = new ArrayList<T>();
    }

    Ringpuffer(Ringpuffer<T> puffer){
        this.capacity = puffer.capacity;
        this.fixedCpacity = puffer.fixedCpacity;
        this.discarding = puffer.discarding;

        elements = (ArrayList<T>) puffer.elements.clone();
        this.writePos = puffer.writePos;
        this.readPos = puffer.readPos;
        this.size = puffer.size;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (capacity < 1 || elements == null) ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        Objects.requireNonNull(o);
        //ueberprueft ob o ein object ist, wenn ja wird es true zuruecjgegeben, wenn nicht fales.
        return elements.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return RingpufferInterator<>(this, false);
    }

    @Override
    public Object[] toArray() {
        ArrayList list = new ArrayList();
        for(Iterator i = iterator(); i.hasNext(); ){
            list.add(i.next());
        }
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        ArrayList<T> list = new ArrayList<>();
        for(Iterator<T> i = iterator(); i.hasNext();){
            list.add(i.next());
        }
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return false;
    }

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
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }


    @Override
    protected Objects clone(){
        return new Ringpuffer<T>(this);
    }
}
*/
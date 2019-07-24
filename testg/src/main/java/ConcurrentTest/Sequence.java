package ConcurrentTest;


//@ThreadSafe
public class Sequence {
//    @GuardedBy("this") private int nextValue;
    private int nextValue;


    public synchronized int getNext() {
        return nextValue++;
    }
}
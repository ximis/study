package HighWayMemery;

public class ExpensiveFunction implements Computable<String, Integer> {
    @Override
    public Integer compute(String arg) throws InterruptedException {
        return new Integer(arg);
    }
}

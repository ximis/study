package HighWayMemery;

/**
 * thread safe class
 */

import java.util.Map;
import java.util.concurrent.*;
public class Memorizer<A, V> implements Computable<A, V>{
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;


    public Memorizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> result = cache.get(arg);
        if(result == null){
            FutureTask<V> futureTask = new FutureTask<V>(new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            });

            result = cache.putIfAbsent(arg,futureTask);

            if(result ==null) {
                result = futureTask;
                futureTask.run();
            }
        }

        try {
            return result.get();
        }catch (ExecutionException e){
            System.out.println(e.getCause());
//            throw (e.getCause());
        }

        return null;
    }

}
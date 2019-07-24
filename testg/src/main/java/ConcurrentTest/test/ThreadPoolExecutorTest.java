package ConcurrentTest.test;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args){
        ExecutorService executorService = new MyThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        for(int i =0; i<10; i++){
            executorService.submit(()->{
                System.out.println("this is i");
            });
        }
    }
}

class MyThreadPoolExecutor extends ThreadPoolExecutor{
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("before test ....");
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("after test ....");
        super.afterExecute(r, t);
    }
}

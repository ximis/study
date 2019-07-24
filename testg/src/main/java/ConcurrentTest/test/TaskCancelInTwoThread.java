package ConcurrentTest.test;

import java.util.concurrent.*;

public class TaskCancelInTwoThread {
    public static void main(String[] args){
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();


        Future future = null;
         FutureTask<Void> dataCancel = null;

        for(int i =0; i< 10; i ++){
//            MyRunnable task = new MyRunnable(i);
            FutureTask<Void> task = new FutureTask<Void>(new MyCallable<Void>(i));

            if(i == 0) {
//                future = executorService1.submit(task);
                dataCancel = task;
            }else {
                executorService1.submit(task);
            }
            executorService2.submit(task);
        }
//        future.cancel(true);
        dataCancel.cancel(true);

        executorService1.shutdown();
        executorService2.shutdown();

    }
}

class MyRunnable implements Runnable{
    private int value;
    public MyRunnable(int i ){
        value = i;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2 * 1000);
        }catch (InterruptedException e){
            System.out.println("the case is interrupted.");
        }

        System.out.println(Thread.currentThread().getName() + ": " + value);
    }
}

class MyCallable<V> implements Callable<V>{
    private  int value;

    public MyCallable(int i){
        value = i;
    }

    @Override
    public V call() throws Exception {
        try {
            Thread.sleep(2 * 1000);
        }catch (InterruptedException e){
            System.out.println("the case is interrupted.");
        }

        System.out.println(Thread.currentThread().getName() + ": " + value);
    return null;
    }


}


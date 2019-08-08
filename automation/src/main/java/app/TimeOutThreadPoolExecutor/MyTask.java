package app.TimeOutThreadPoolExecutor;

import java.util.concurrent.Callable;

public class MyTask implements Callable<Void> {

    @Override
    public Void call() throws Exception {

        Thread.sleep(10 * 1000);
        System.out.println("run the task");

        return null;
    }

}

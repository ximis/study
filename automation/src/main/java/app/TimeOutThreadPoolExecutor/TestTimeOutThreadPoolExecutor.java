package app.TimeOutThreadPoolExecutor;

import java.util.concurrent.*;

public class TestTimeOutThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException{
        TimeOutThreadPoolExecutor executorService = new TimeOutThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());

        for(int i =0; i< 10; i ++){
            Thread.sleep(1 * 1000);
            executorService.submit(new MyTask());
        }
        System.out.println("It's time to start check function.");

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.HOURS);
    }
}

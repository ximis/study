package app.Common;

import org.apache.logging.log4j.ThreadContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Logs {

    public static void main(String[] args) throws Exception {
        org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger("mylog");

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                String name = Thread.currentThread().getName();
                ThreadContext.put("ROUTINGKEY", Thread.currentThread().getName());

                logger.debug(name);
                try {
                    Thread.sleep(10 * 1000);
                }
                catch (Exception ingore) {

                }
                ThreadContext.put("ROUTINGKEY", Thread.currentThread().getName() + "2222");
                logger.debug(name);
                logger.debug(name);
                logger.debug(name);
                logger.debug(name);
                logger.debug(name);
                logger.debug(name);

            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1 * 60, TimeUnit.SECONDS);
    }
}

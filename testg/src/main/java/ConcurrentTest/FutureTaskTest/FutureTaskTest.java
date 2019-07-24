package ConcurrentTest.FutureTaskTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 用来表示一些时间较长的计算，这些计算可以使用计算结果之前启动。
 */
public class FutureTaskTest {
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return null;
        }
    });

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws InterruptedException {
        try {
            return future.get();
        }
        catch (ExecutionException e) {
            Throwable cause = e.getCause();
        }
        return null;
    }

}

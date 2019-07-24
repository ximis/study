package ConcurrentTest;

import java.util.concurrent.CountDownLatch;

/**
 * 一个统计线程执行时间的测试程序
 */
public class CountDownLatchTest {
    public static long timeTasks(int nThread, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThread);

        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        }
                        finally {
                            endGate.countDown();
                        }
                    }
                    catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    private static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("dfasdfadsf");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        CountDownLatchTest test = new CountDownLatchTest();
        long time = timeTasks(10, new MyThread());
        System.out.println(time + "");
    }
}

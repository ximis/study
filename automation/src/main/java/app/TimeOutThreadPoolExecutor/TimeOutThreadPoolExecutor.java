package app.TimeOutThreadPoolExecutor;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class TimeOutThreadPoolExecutor extends ThreadPoolExecutor {

    //this part is used to do the timeout cancel work.
    private final ExecutorService _executor = Executors.newSingleThreadExecutor();
    private final PriorityBlockingQueue<TimeOutFutureTask> _priorityQueue = new PriorityBlockingQueue<TimeOutFutureTask>(1000, new Comparator<TimeOutFutureTask>() {
        @Override
        public int compare(TimeOutFutureTask o1, TimeOutFutureTask o2) {
            if (o1.getTimeOutTime() == o2.getTimeOutTime()) return 0;
            //because I want the start time smaller at the head.
            return o1.getTimeOutTime() - o2.getTimeOutTime() > 0 ? 1 : -1;
        }
    });

    private class TimeOutFutureTask<V> extends FutureTask<V> {
        private volatile long _startEpoch = 0;
        private final long DEFAULT_TIMEOUT = 30 * 60 * 1000L;

        public TimeOutFutureTask(Callable<V> callable) {
            super(callable);
        }

        public void setStartEpoch(long miliseconds) {
            _startEpoch = miliseconds;
        }

        public boolean isTimeOut() {
            if (_startEpoch == 0) {
                return false;
            }
            return System.currentTimeMillis() - _startEpoch > DEFAULT_TIMEOUT;
        }

        public long getTimeOutTime() {
            return DEFAULT_TIMEOUT - (System.currentTimeMillis() - _startEpoch);
        }

        public long getStartEpoch() {
            return _startEpoch;
        }

    }

    private ExecutorService _timeOutCheckExecutor = Executors.newSingleThreadExecutor();


    public TimeOutThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

        _timeOutCheckExecutor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TimeOutFutureTask task = _priorityQueue.take();
                    System.out.println("time out time: " + task.getTimeOutTime());

                }
                catch (InterruptedException ignore) {
                    System.out.println("fdasdfa");
                    return;
                }

            }
        });
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        if (r instanceof TimeOutFutureTask) {
            TimeOutFutureTask task = (TimeOutFutureTask) r;
            task._startEpoch = System.currentTimeMillis();
            _priorityQueue.put(task);
        }
        super.beforeExecute(t, r);

    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new TimeOutFutureTask<T>(callable);
    }

    @Override
    public void shutdown() {
        super.shutdown();
        _timeOutCheckExecutor.shutdownNow();

    }

    @Override
    public List<Runnable> shutdownNow() {
        _timeOutCheckExecutor.shutdownNow();
        return super.shutdownNow();
    }
}

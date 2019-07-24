package ConcurrentTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest extends Thread{
    private String name;
    private Semaphore sh;

    public SemaphoreTest(String name, Semaphore sh){
        this.name = name;
        this.sh = sh;
    }


    @Override
    public void run(){
        if(sh.availablePermits() > 0){
            try{
                System.out.println("有笔了。");
                sh.acquire();
                System.out.println(name + "号正在用笔。");
                Thread.sleep((long)Math.random()* 1000);
                sh.release();
                System.out.println(name + "号用完笔了。");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("暂时没有笔了， 先等等。");

        }
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore sh = new Semaphore(3);
        for(int i = 1; i <=20; i ++){
            executorService.submit(new SemaphoreTest(i + "", sh));
        }
        executorService.shutdown();
    }

}

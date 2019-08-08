package ConcurrentTest.PriorityBlockingQueueTest;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest1 {
    public static void main(String[] args) throws Exception{

        PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>();
        queue.put(new User("1", 1));
        queue.put(new User("2", 2));
        queue.put(new User("3", 3));
        queue.put(new User("32", 3));
        queue.put(new User("4", 4));

        while (!queue.isEmpty()){
            System.out.println(queue.take().name);
        }

    }
}

class User implements Comparable<User>{
    public String name;
    private int age;
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return  this.age - o.age >0 ? 1: -1;
    }


}


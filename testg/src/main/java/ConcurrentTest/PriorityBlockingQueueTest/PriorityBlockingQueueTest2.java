package ConcurrentTest.PriorityBlockingQueueTest;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest2 {
    public static void main(String[] args) throws Exception {

        PriorityBlockingQueue<User2> queue = new PriorityBlockingQueue<User2>(1000, new Comparator<User2>() {

            @Override
            public int compare(User2 o1, User2 o2) {
                if(o1.age == o2.age)  return 0;
                return o1.age -o2.age > 0 ? 1 : -1;
            }
        });
        queue.put(new User2("1", 1));
        queue.put(new User2("2", 2));
        queue.put(new User2("3", 3));
        queue.put(new User2("32", 3));
        queue.put(new User2("4", 4));

        while (!queue.isEmpty()) {
            System.out.println(queue.take().name);
        }

    }
}

class User2 {
    public String name;
    public int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

}


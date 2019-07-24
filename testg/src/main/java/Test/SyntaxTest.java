package Test;

import java.util.LinkedList;
import java.util.List;

public class SyntaxTest {
    public static void main(String[] args){

        List<Test> test = new LinkedList<Test>();
        test.add(new Test(1));
        test.add(new Test(2));
        test.add(new Test(3));

        test.forEach(Test::log);


    }
}

class Test{
    private int i;
    public Test(int i){
        this.i = i;
    }
    public void log(){
        System.out.println("this is the log " + i);
    }
}

package GroovyEvalTest;

public class GroovyEvalTest {
    public static void main(String args[]){
        System.out.println(Math.sqrt(2/0.1));
        String data = Byte.MAX_VALUE + "";
        System.out.println(data);
        System.out.print(Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY);

    }
}

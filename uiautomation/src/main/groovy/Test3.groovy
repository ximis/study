import GroovyTest.TestProxy;

public class Test3 {

    public static void main(String[] args){

        GroovyTest test = (GroovyTest) new TestProxy().getInstance(GroovyTest.class);

        test.age = 10;
        test.age = 11;




    }
}

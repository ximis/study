import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestAnnotation {


    @BeforeTest
    public void before(){
        System.out.println("This is Before Test!!");
    }


    @Test
    public void test() {
        System.out.println("test.test-");
    }


}

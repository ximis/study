public class TestParameters {

    public static void main(String[] args){

        new TestParameters().test("aaa","bbb","ccc");
    }

    public void test(String ... values){
        for(String value:values){
            System.out.println(value);
        }
    }

}

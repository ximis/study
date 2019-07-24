package EnumTest;

public class EnumTest {

    public static void main(String args[]){
        System.out.print(Test.AAA.value);
        System.out.print(Test2.AAA);
    }

    public static enum Test{
        AAA(1),
        BBB(2);

        private int  value=0;
        private Test(int value)
        {
            this.value=value;
        }
    }

    public static enum Test2{
        AAA,
        BBB,
        CCC;
    }
}

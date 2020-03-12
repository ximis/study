package TestsDynamicProxy;

public class TargetObject {

    private String name;
    private int age;
    public String school;


    public TargetObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int sum(int x, int y){
        return x+y;
    }
}

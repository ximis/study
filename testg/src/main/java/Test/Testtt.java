package Test;

public class Testtt {
    public static void main(String[] args){
        System.out.println(caculate(8.28, 9, 0.15, 0.09, 0.05));
    }

    public static double caculate(double source, double year, double increaseRate, double dRate, double fRate){
        double rate = (1 + increaseRate) / (1 + dRate);
        double result = source * ((Math.pow(rate, year)) - 1)/ (rate -1);

        result  = result + source * Math.pow((1 + increaseRate), year)/(1 - (1 + fRate)/(1 + dRate));
        return result;
    }
}

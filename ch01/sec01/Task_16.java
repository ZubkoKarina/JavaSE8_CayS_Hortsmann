package ch01.sec01;

public class Task_16{
    public static void main(String[] args){
        System.out.println(average(2, 5, 6, 4, 3, 5, 8.7));
    }
    public static double average(double... values) {
        if (values.length == 0) {
            return 0;
        }
        double sum = 0;
        for (double value: values) {
            sum += value;
        }
        return sum / values.length;
    }
    
}




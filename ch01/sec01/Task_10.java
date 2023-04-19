package ch01.sec01;
import java.util.Random;

public class Task_10{
    public static void main (String[] args){
        Random rand = new Random();
        long num = rand.nextLong();
        String str = Long.toString(num, 36);
        System.out.println(str);
    }
}
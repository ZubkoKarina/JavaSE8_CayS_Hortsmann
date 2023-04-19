package ch01.sec01;
import java.util.Scanner;

public class Task_4{
    public static void main(String[] args){
        double max = Double.MAX_VALUE;
        double min = Math.nextUp(max);
        System.out.println(min);
    }
}
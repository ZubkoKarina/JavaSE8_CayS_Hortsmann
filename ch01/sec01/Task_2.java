package ch01.sec01;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter int numbers:");
        int num = in.nextInt();
        int normalizedNumber = num%360;
        if (normalizedNumber<0){
            normalizedNumber *= (-1);
        }
        System.out.println(normalizedNumber);
        normalizedNumber = Math.floorMod(num, 360);
        System.out.println(normalizedNumber);
    } 
}
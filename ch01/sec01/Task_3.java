package ch01.sec01;
import java.util.Scanner;

public class Task_3{
    public static void main(String[] args){
        System.out.print("Enter numbers: ");
        Scanner in = new Scanner(System.in); 
        int firstNum = in.nextInt();
        int secondNum = in.nextInt();
        int thirdNum = in.nextInt();
        int max = firstNum > secondNum ? firstNum : secondNum;
        max = max > thirdNum ? max : thirdNum;
        System.out.println("Max: " + max); 
    }  
}
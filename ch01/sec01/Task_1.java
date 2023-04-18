package ch01.sec01;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number:");
        int num = in.nextInt();
        String binary = Integer.toBinaryString(num);
        String octal = Integer.toOctalString(num);
        String hexadecimal = Integer.toHexString(num);
        double inverse = 1.0/num;
        String hexInverse = Double.toHexString(inverse);
        System.out.println(hexInverse);
    }
}
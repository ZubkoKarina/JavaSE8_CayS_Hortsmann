package ch01.sec01;
import java.util.Scanner;
import java.math.BigInteger;

public class Task_7{
    public static void main(String[] args){
        System.out.println("Enter two numers: ");
        Scanner in = new Scanner(System.in);
        BigInteger firstNum = in.nextBigInteger();
        while((firstNum.compareTo(BigInteger.ZERO) < 0) || 
        (firstNum.compareTo(new BigInteger("65535")) > 0)){
            System.out.println("[0;65535]");
            firstNum = in.nextBigInteger();
        }
        BigInteger secondNum = in.nextBigInteger();
        while((secondNum.compareTo(BigInteger.ZERO) < 0) || 
        (secondNum.compareTo(new BigInteger("65535")) > 0)){
            System.out.println("[0;65535]");
            secondNum = in.nextBigInteger();
        }
    }
}
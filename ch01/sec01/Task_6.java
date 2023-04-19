package ch01.sec01;
import java.math.BigInteger;

public class Task_6{
    public static void main(String[] args){
        System.out.println(getFactorial(1000));
    }
    public static BigInteger getFactorial(int num){
        BigInteger result = BigInteger.ONE;
        for(int i = 1; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
package ch01.sec01;
import java.lang.StringBuilder;
import java.util.Scanner;

public class Task_8{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter str: ");
        String str = in.nextLine();
        StringBuilder strB = new StringBuilder(str);
        for(int i = 0;i < strB.length();i++){
            for(int j = 1+i;j<= strB.length(); j++){
                String subStr = strB.substring(i, j);
                if(!subStr.isEmpty()){
                    System.out.println(subStr);
                }
            }
        }
    }
}
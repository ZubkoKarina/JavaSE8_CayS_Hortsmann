package ch01.sec01;

public class Task_9{
    public static void main (String[] args){
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello";
        if (s1 + s2 == s3 + s2) {
            System.out.println("s1 + s2 equals s3 + s2");
        } else {
            System.out.println("s1 + s2 does not equal s3 + s2");
        }
    }
}
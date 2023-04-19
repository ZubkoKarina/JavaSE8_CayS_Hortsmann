package ch01.sec01;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = in.nextLine();
        Set<Integer> unicodeSet = new HashSet<Integer>();
        for(int i = 0; i < str.length(); i++) {
            int unicode = str.codePointAt(i);
            if(unicode > 127) {
                unicodeSet.add(unicode);
            }
        }
        System.out.println("Characters not represented in ASCII: ");
        for(int codePoint : unicodeSet) {
            System.out.println(Character.toChars(codePoint) + " - " + codePoint);
        }
    }
}

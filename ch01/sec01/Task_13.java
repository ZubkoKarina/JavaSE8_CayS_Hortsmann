package ch01.sec01;
import java.util.ArrayList;
import java.util.Collections;

public class Task_13 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        System.out.print("Лотерейная комбинация: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }
}

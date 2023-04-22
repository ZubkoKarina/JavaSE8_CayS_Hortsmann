package ch02.sec01;
import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    private static final Random rand = new Random();
    public static int randomElement(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int index = rand.nextInt(array.length);
        return array[index];
    }
    public static Integer randomElement(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Random element from array: " + randomElement(arr));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("Random element from list: " + randomElement(list));
    }
}


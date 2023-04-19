package ch01.sec01;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows in Pascal's triangle: ");
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    ArrayList<Integer> prevRow = triangle.get(i - 1);
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(sum);
                }
            }
            triangle.add(row);
        }
        for (ArrayList<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}

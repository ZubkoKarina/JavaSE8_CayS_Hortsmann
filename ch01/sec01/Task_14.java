package ch01.sec01;

import java.util.Scanner;

public class Task_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность массива (от 2 до 10): ");
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        boolean isMagicSquare = true;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
        }
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
            }
            if (rowSum != sum) {
                isMagicSquare = false;
                break;
            }
        }
        if (isMagicSquare) {
            for (int j = 0; j < n; j++) {
                int colSum = 0;
                for (int i = 0; i < n; i++) {
                    colSum += arr[i][j];
                }
                if (colSum != sum) {
                    isMagicSquare = false;
                    break;
                }
            }
        }
        if (isMagicSquare) {
            int diag1Sum = 0;
            int diag2Sum = 0;
            for (int i = 0; i < n; i++) {
                diag1Sum += arr[i][i];
                diag2Sum += arr[i][n - 1 - i];
            }
            if (diag1Sum != sum || diag2Sum != sum) {
                isMagicSquare = false;
            }
        }
        if (isMagicSquare) {
            System.out.println("Массив содержит магический квадрат");
        } else {
            System.out.println("Массив не содержит магический квадрат");
        }
    }
}

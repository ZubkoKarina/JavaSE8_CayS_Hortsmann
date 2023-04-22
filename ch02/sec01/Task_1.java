package ch02.sec01;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Task_1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now().withDayOfMonth(1);
        int month = date.getMonthValue();
        int year = date.getYear();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int daysInMonth = date.lengthOfMonth();
        System.out.printf("%2s %2s %2s %2s %2s %2s %2s\n",
                "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");
        int indentation = dayOfWeek.getValue() % 7;
        for (int i = 0; i < indentation; i++) {
            System.out.print("   ");
        }
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%2d ", i);
            if ((i + indentation) % 7 == 0) {
                System.out.println();
            }
        }
    }
}

package ch02.sec01;
import java.time.LocalDate;

public class OOP{
    public static void main(String[] args){
        LocalDate date = LocalDate.of(2023, 5, 18);
        System.out.println(date);
        System.out.println(date.plusDays(1));
    }
}

/*
* утилита javadoc обрабатывает исходный код в HTML-файлы 
* класс LocalDate date = LocalDate.of(year, month, 1);
*
*
*
*
*/
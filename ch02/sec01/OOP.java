package ch02.sec01;
import java.time.LocalDate;
import java.util.ArrayList;

public class OOP{
    public static void main(String[] args){
        LocalDate date = LocalDate.of(2023, 5, 18);
        System.out.println(date);
        System.out.println(date.plusDays(1));
        Employee kotlimDev = new Employee("Tim", 5000);
        System.out.println(kotlimDev.getName());
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Karina", 10000));
    }
    public static class Employee{
        private String name;
        private double salary;
        public Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }
        public Employee(double salary){
            this("", name);
            this.salary = salary;
        }
        public void raiseSalary(double byPercent){
            double raise = salary * byPercent/100;
            salary += raise;
        }
        public String getName(){
            return name;
        }
        /* as a method!
        public void Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }*/
    }
}

/*
* утилита javadoc обрабатывает исходный код в HTML-файлы 
* класс LocalDate date = LocalDate.of(year, month, 1);
*
* Если случайно обьявить void public void Employee(...)- не конструктор, а метод!
*
*
*
*/


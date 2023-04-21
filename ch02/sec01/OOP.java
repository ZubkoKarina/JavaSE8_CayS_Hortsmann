package ch02.sec01;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

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
        private final String name;
        private double salary = 500.0;
        //блок инициализации(обычно не используются)
        {
            Random generator = new Random();
            salary = 1+generator.nextInt(1_000_000);
        }
        public Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }
        public Employee(double salary){
            // this.name = "";
            // this.salary = salary;
            this("", salary);
        }
        public Employee(String name){
            // для обьектов будет вызывать исключение в getName()
            // salary = 0;
            this.name = name;
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
* Переменная экземпляра класса final - обязана быть инициализирована к концу определения каждого конструктора
* но private fienl ArrayList<Person> friends = new ArrayList<>() - неизменяема только ссылка, а изменять обьект можно(можно изменять содержимое массива, но они не могут заменить ссылку)
*/


package ch03.sec01;

public class task_1{
    interface Measurable{
        double getMeasure();
    }
    public static class Employee implements Measurable{
        private String name;
        private double salary;
        public Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }
        public double getMeasure(){
            return salary;
        }
        public static double average(Measurable[] objects){
            double sum = 0;
            for(Measurable obj: objects){
                sum += obj.getMeasure();
            }
            return sum/objects.length;
        }
    }
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("John", 1000);
        employees[1] = new Employee("Mary", 1200);
        employees[2] = new Employee("Bob", 1150);
        System.out.println(Employee.average(employees));
    }
}
package ch03.sec01;

public class task_2{
    interface Measurable{
        double getMeasure();
        String getName();
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
        public String getName(){
            return name;
        }
        public static double average(Measurable[] objects){
            double sum = 0;
            for(Measurable obj: objects){
                sum += obj.getMeasure();
            }
            return sum/objects.length;
        }
        public static Measurable largest(Measurable[] objects){
            Measurable largest = (Employee)objects[0];
            for(Measurable obj: objects){
                if(obj.getMeasure() > largest.getMeasure()){
                    largest = (Employee)obj;
                }
            }
            return largest;
        }
    }
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("John", 1000);
        employees[1] = new Employee("Mary", 1200);
        employees[2] = new Employee("Bob", 1150);
        System.out.println(Employee.average(employees));
        System.out.println(((Employee)Employee.largest(employees)).getName());
    }
}
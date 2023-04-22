package ch02.sec01;

public class Car {
    private double fuelEfficiency; 
    private double fuelLevel; 
    private double distance; 
    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
        this.fuelLevel = 0;
        this.distance = 0;
    }
    public void drive(double kilometers) {
        double fuelNeeded = kilometers / fuelEfficiency;
        if (fuelNeeded <= fuelLevel) {
            distance += kilometers;
            fuelLevel -= fuelNeeded;
        } else {
            System.out.println("Not enough fuel to drive this distance!");
        }
    }
    public void fill(double liters) {
        fuelLevel += liters;
    }
    public double getDistance() {
        return distance;
    }
    public double getFuelLevel() {
        return fuelLevel;
    }
    public static void main(String[] args) {
        Car car = new Car(10); 
        System.out.println("Initial fuel level: " + car.getFuelLevel() + " liters");
        System.out.println("Initial distance: " + car.getDistance() + " km");
        car.fill(50);
        System.out.println("After filling up: " + car.getFuelLevel() + " liters");
        car.drive(100); 
        System.out.println("Distance driven: " + car.getDistance() + " km");
        System.out.println("Fuel level after driving: " + car.getFuelLevel() + " liters");
        car.drive(500); 
}

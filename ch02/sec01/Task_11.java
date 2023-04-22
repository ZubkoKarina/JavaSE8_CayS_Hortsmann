package ch02.sec01;
import static java.time.LocalDate.now;
import static java.lang.System.out;

public class Car1 {
    private double fuelEfficiency;
    private double fuelLevel;
    private double distanceDriven;
    public Car1(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
    public void drive(double distance) {
        double fuelNeeded = distance / fuelEfficiency;
        if (fuelNeeded <= fuelLevel) {
            distanceDriven += distance;
            fuelLevel -= fuelNeeded;
            out.printf("Drove %.2f km, %.2f litres of fuel remaining\n", distance, fuelLevel);
        } else {
            out.println("Insufficient fuel to drive that far");
        }
    }
    public void addFuel(double litres) {
        fuelLevel += litres;
        out.printf("%.2f litres added to fuel tank\n", litres);
    }
    public double getDistanceDriven() {
        return distanceDriven;
    }
    public double getFuelLevel() {
        return fuelLevel;
    }
    public static void main(String[] args) {
        Car1 car = new Car1(8.5);
        car.addFuel(45);
        car.drive(200);
        out.printf("Fuel remaining: %.2f litres\n", car.getFuelLevel());
        out.printf("Distance driven: %.2f km\n", car.getDistanceDriven());
        out.printf("Date: %s\n", now());
    }
}

import Classes.Engine;
import Classes.Vehicle;

import java.util.Scanner;

public class VehicleExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int power = Integer.parseInt(sc.nextLine());
        String [] vehicleDetails = sc.nextLine().split("[, ]+"); //type, model, fuel
        Engine engine = new Engine(power);
        Vehicle vehicle = new Vehicle(vehicleDetails[0], vehicleDetails[1], engine, Integer.parseInt(vehicleDetails[2]));
        vehicle.drive(100);
        System.out.println(vehicle.getFuel());
    }
}

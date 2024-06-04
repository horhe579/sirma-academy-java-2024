import Classes.Car;

import java.util.ArrayList;
import java.util.Scanner;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    ArrayList<Car> cars = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        String[] carInfo = sc.nextLine().split("[, ]+");

        //Car car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
        //Car car = new Car(carInfo[0]);

        //cars.add(car);
    }

    for (int i = 0; i < cars.size(); i++) {
        System.out.println(STR."Info: \{cars.get(i).printCarInfo()}.");
    }
}

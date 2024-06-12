import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

//15 min

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (true) {
            String[] command = sc.nextLine().split("[, ]+");

            switch (command.length) {
                case 2:
                    switch (command[0].toLowerCase()) {
                        case "in":
                            //move car in parkingLot
                            parkCar(parkingLot, command[1]);
                            break;
                        case "out":
                            //move car out of parkingLot
                            moveCar(parkingLot, command[1]);
                            break;
                        default:
                            System.err.println("Invalid command.");
                            break;
                    }
                    break;
                case 1:
                    switch (command[0].toLowerCase()) {
                        case "end":
                            //print parkingLot
                            System.out.println(printParkingLot(parkingLot));
                            return;
                        default:
                            System.err.println("Invalid command.");
                            break;
                    }
                    break;
                default:
                    System.err.println("Invalid command.");
                    break;
            }
        }
    }

    private static void parkCar(LinkedHashSet<String> parkingLot, String carNumber) {
        if (!parkingLot.contains(carNumber)) {
            parkingLot.add(carNumber);
        } else {
            System.out.println(STR."Car \{carNumber} already parked!");
        }
    }

    private static void moveCar(LinkedHashSet<String> parkingLot, String carNumber) {
        if (!parkingLot.contains(carNumber)) {
            System.out.println(STR."Cannot move car \{carNumber} out since it is not parked!");
        } else {
            parkingLot.remove(carNumber);
        }
    }

    private static String printParkingLot(LinkedHashSet<String> parkingLot)
    {
        return (parkingLot.isEmpty()) ? STR."Parking Lot is Empty"
                : STR."\{parkingLot.stream().collect(Collectors.joining("\n"))}";
    }
}

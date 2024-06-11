import java.util.Arrays;
import java.util.Scanner;

public class RohanCavalryFormation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] riders1 = Arrays.stream(sc.nextLine().split("[, ]+")).mapToInt(Integer::parseInt).toArray();

        while (true) {
            String[] commands = sc.nextLine().split("[ ]+");
            try {
                switch (commands[0].toLowerCase()) {
                    case "destroy":
                        if (commands.length != 2) {
                            throw new IllegalArgumentException("Invalid command syntax for 'destroy'.");
                        }
                        riders1 = destroyRiderArray(riders1, Integer.parseInt(commands[1]));
                        break;
                    case "swap":
                        if (commands.length != 3) {
                            throw new IllegalArgumentException("Invalid command syntax for 'swap'.");
                        }
                        swapRidersArray(riders1, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                        break;
                    case "add":
                        if (commands.length != 2) {
                            throw new IllegalArgumentException("Invalid command syntax for 'add'.");
                        }
                        riders1 = addRiderArray(riders1, Integer.parseInt(commands[1]));
                        break;
                    case "insert":
                        if (commands.length != 3) {
                            throw new IllegalArgumentException("Invalid command syntax for 'insert'.");
                        }
                        riders1 = insertRiderArray(riders1, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                        break;
                    case "center":
                        displayCenterRiderArray(riders1);
                        break;
                    case "end":
                        sc.close();
                        return;
                    default:
                        throw new IllegalArgumentException("Not a valid command.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid rider ID or index.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static int[] destroyRiderArray(int[] riders, int index) {
        if (index < 0 || index >= riders.length) {
            System.err.println("Index not in array.");
            return riders;
        }
        int[] ridersClone = new int[riders.length - 1];
        for (int i = 0, j = 0; i < riders.length; i++) {
            if (i != index) {
                ridersClone[j++] = riders[i];
            }
        }
        printRiders(ridersClone);
        return ridersClone;
    }

    public static void swapRidersArray(int[] riders, int index1, int index2) {
        if ((index1 < 0 || index1 >= riders.length) || (index2 < 0 || index2 >= riders.length)) {
            System.err.println("Index not in array.");
            return;
        }
        int temp = riders[index1];
        riders[index1] = riders[index2];
        riders[index2] = temp;
        printRiders(riders);
    }

    public static int[] addRiderArray(int[] riders, int riderID) {
        int[] ridersClone = new int[riders.length + 1];
        for (int i = 0; i < riders.length; i++) {
            ridersClone[i] = riders[i];
        }
        ridersClone[riders.length] = riderID;
        printRiders(ridersClone);
        return ridersClone;
    }

    public static int[] insertRiderArray(int[] riders, int riderID, int index) {
        if (index < 0 || index > riders.length) {
            System.err.println("Index not in array.");
            return riders;
        }
        int[] ridersClone = new int[riders.length + 1];
        int j = 0;
        for (int i = 0; i < riders.length; i++) {
            if (i == index) {
                ridersClone[j++] = riderID;
            } else {
                ridersClone[j++] = riders[i];
            }
        }
        if (index == riders.length) {
            ridersClone[j] = riderID;
        }
        printRiders(ridersClone);
        return ridersClone;
    }

    public static void displayCenterRiderArray(int[] riders) {
        System.out.println((riders.length % 2 == 0)
                ? STR."\{riders[riders.length / 2 - 1]} \{riders[riders.length / 2]}"
                : STR."\{riders[riders.length / 2]}"
        );
    }

    public static void printRiders(int[] riders) {
        Arrays.stream(riders).forEach(r -> System.out.print(STR."\{r} "));
        System.out.println();
    }
}

import Classes.Product;
import Classes.Robot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Factorio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Product> productAssemblyLine = new ArrayDeque<>();
        Robot freeRobot = null;

        Robot[] robotWorkers = Arrays.stream(sc.nextLine().split("\\|"))
                .map(robot -> {
                    String[] details = robot.split("-");
                    return new Robot(details[0], Integer.parseInt(details[1]));
                })
                .toArray(Robot[]::new);


        int[] time = Arrays.stream(sc.nextLine().split(":")).
                mapToInt(Integer::parseInt).
                toArray();

        //get the products
        while (true) {
            String product = sc.nextLine();
            if (product.toLowerCase().equals("end")) {
                break;
            }
            productAssemblyLine.offer(new Product(product.trim()));
        }

        while (!productAssemblyLine.isEmpty()) {
            time[2]++;
            Robot.correctTimeFormat(time);
            freeRobot = null;
            for (Robot robot : robotWorkers) {
                if (compareTimes(time, robot.getAvailableAt())) {
                    freeRobot = robot;
                    break;
                }
            }
            if (freeRobot != null) {
                freeRobot.processProduct(productAssemblyLine.poll(), time);
            } else {
                productAssemblyLine.offer(productAssemblyLine.poll());
            }
        }
    }

    public static boolean compareTimes(int[] currentTime, ArrayList<Integer> availableAt) {

        return (currentTime[0] > availableAt.get(0))
                ? true
                : (currentTime[0] < availableAt.get(0))
                ? false
                : (currentTime[1] > availableAt.get(1))
                ? true
                : (currentTime[1] < availableAt.get(1))
                ? false
                : currentTime[2] >= availableAt.get(2);
    }
}

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String vegetable = scanner.nextLine().toLowerCase();
        String dayOfWeek = scanner.nextLine().toLowerCase();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0.0;
        boolean validInput = true;

        switch (dayOfWeek) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
                switch (vegetable) {
                    case "tomato":
                        price = 2.50;
                        break;
                    case "onion":
                        price = 1.20;
                        break;
                    case "lettuce":
                        price = 0.85;
                        break;
                    case "cucumber":
                        price = 1.45;
                        break;
                    case "pepper":
                        price = 5.50;
                        break;
                    default:
                        validInput = false;
                }
                break;
            case "saturday":
            case "sunday":
                switch (vegetable) {
                    case "tomato":
                        price = 2.80;
                        break;
                    case "onion":
                        price = 1.30;
                        break;
                    case "lettuce":
                        price = 0.85;
                        break;
                    case "cucumber":
                        price = 1.75;
                        break;
                    case "pepper":
                        price = 3.50;
                        break;
                    default:
                        validInput = false;
                }
                break;
            default:
                validInput = false;
        }

        if (validInput) {
            double totalCost = price * quantity;
            System.out.println(String.format("%.2f", totalCost));
        } else {
            System.out.println("error");
        }

        scanner.close();
    }
}

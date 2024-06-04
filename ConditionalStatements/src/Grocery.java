import java.util.Scanner;

public class Grocery{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine().toLowerCase();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0.0;

        if (city.equalsIgnoreCase("Sofia")) {
            if (product.equals("tea")) {
                price = 0.50;
            } else if (product.equals("water")) {
                price = 0.80;
            } else if (product.equals("juice")) {
                price = 1.20;
            } else if (product.equals("sweets")) {
                price = 1.45;
            } else if (product.equals("chips")) {
                price = 1.60;
            } else {
                System.out.println("Invalid product");
                return;
            }
        } else if (city.equalsIgnoreCase("Plovdiv")) {
            if (product.equals("tea")) {
                price = 0.40;
            } else if (product.equals("water")) {
                price = 0.70;
            } else if (product.equals("juice")) {
                price = 1.15;
            } else if (product.equals("sweets")) {
                price = 1.30;
            } else if (product.equals("chips")) {
                price = 1.50;
            } else {
                System.out.println("Invalid product");
                return;
            }
        } else if (city.equalsIgnoreCase("Varna")) {
            if (product.equals("tea")) {
                price = 0.45;
            } else if (product.equals("water")) {
                price = 0.70;
            } else if (product.equals("juice")) {
                price = 1.10;
            } else if (product.equals("sweets")) {
                price = 1.35;
            } else if (product.equals("chips")) {
                price = 1.55;
            } else {
                System.out.println("Invalid product");
                return;
            }
        } else {
            System.out.println("Invalid city");
            return;
        }

        double totalCost = price * quantity;
        System.out.printf("%.2f%n", totalCost);

        scanner.close();
    }
}

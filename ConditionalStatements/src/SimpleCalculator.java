import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        String operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case "add":
                System.out.println(String.format("%.2f", a + b));
                break;
            case "subtract":
                System.out.println(String.format("%.2f", a - b));
                break;
            case "multiply":
                System.out.println(String.format("%.2f", a * b));
                break;
            case "divide":
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println(String.format("%.2f", a / b));
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        scanner.close();
    }
}

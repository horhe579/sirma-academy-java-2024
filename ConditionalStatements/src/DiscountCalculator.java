import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = scanner.nextInt();

        scanner.nextLine();

        String hasMembership = scanner.nextLine().toLowerCase();

        double discount = 0.0;

        if (age < 18)
        {
            discount = 0.10;
        } else if (age >= 18 && age <= 64)
        {
            if (hasMembership.equals("yes"))
            {
                discount = 0.20;
            } else {
                discount = 0.10;
            }
        } else if (age >= 65)
        {
            discount = 0.30;
        }

        System.out.println((int)(discount * 100) + "% discount");

        scanner.close();
    }
}

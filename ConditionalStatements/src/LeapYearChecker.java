import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        scanner.close();

        String result = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? "It‘s a leap year!" : "It‘s not a leap year.";

        System.out.println(result);
    }


}

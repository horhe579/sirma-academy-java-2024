import java.util.Scanner;

public class MovieTicketPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        scanner.close();

        if(age > 0 && age < 13)
        {
            System.out.println("$5");
        }
        else if(age >= 13 && age <= 19)
        {
            System.out.println("$8");
        }
        else if(age >= 20)
        {
            System.out.println("$10");
        }
    }
}

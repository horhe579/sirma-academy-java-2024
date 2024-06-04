import java.util.Scanner;

public class Holiday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = 0.0;
        String season = "";
        while(true)
        {
            budget = Double.parseDouble(scanner.nextLine());
            if(budget >= 10.0 && budget <= 5000.0)
            {
                break;
            }
        }
        while(true)
        {
            season = scanner.nextLine().toLowerCase();
            if(season.equals("summer") || season.equals("winter"))
            {
                break;
            }
        }
        scanner.close();

        if(budget <= 100.0)
        {
            System.out.println("Somewhere in Bulgaria");
            if(season.equals("summer"))
            {
                System.out.printf("Camp - %.2f", budget * 0.30);
            }
            else
            {
                System.out.printf("Hotel - %.2f", budget * 0.70);
            }
        }
        else if(budget <= 1000.0)
        {
            System.out.println("Somewhere in Europe");
            if(season.equals("summer"))
            {
                System.out.printf("Camp - %.2f", budget * 0.40);
            }
            else
            {
                System.out.printf("Hotel - %.2f", budget * 0.80);
            }
        }
        else
        {
            System.out.println("Somewhere in Asia");
            System.out.printf("Hotel - %.2f", budget * 0.90);
        }
    }
}

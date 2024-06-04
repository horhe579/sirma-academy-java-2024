import java.util.Scanner;

public class ClimateZone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double latitude = scanner.nextDouble();
        String hemisphere = scanner.next();
        scanner.close();

        latitude = Math.abs(latitude);

        if(latitude > 66.5)
        {
            System.out.println("Arctic zone");
        }
        else if(latitude > 23.5)
        {
            System.out.println("Temperate zone");
        }
        else if(latitude > 0)
        {
            System.out.println("Tropic zone");
        }
        else
        {
            System.out.println("Eqator");
        }

    }
}

import java.util.Scanner;

public class ArchitecturalEra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        String material = scanner.nextLine();
        String era = "";
        scanner.close();

        if(year < 500 && material.equals("stone"))
        {
            era = "Ancient";
        }
        else if(year >= 500 && year <= 1500 && material.equals("stone"))
        {
            era = "Medieval";
        }
        else if(year >= 1500 && year <= 1800 && material.equals("wood"))
        {
            era = "Colonial";
        }
        else if(year >= 1800 && year <= 1900 && material.equals("steel"))
        {
            era = "Industrial";
        }
        else if(year > 1900 && material.equals("steel"))
        {
            era = "Modern";
        }
        else
        {
            era = "Uncertain";
        }

        System.out.println(era);
    }
}

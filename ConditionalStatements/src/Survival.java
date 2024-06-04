import java.util.Scanner;

public class Survival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String timeOfDay = scanner.nextLine().toLowerCase();
        String environment = scanner.nextLine().toLowerCase();
        String items = scanner.nextLine().toLowerCase();
        String action = "";
        scanner.close();

        if (timeOfDay.equals("day")) {
            if (environment.equals("forest")) {
                if (items.contains("knife")) {
                    action = "Hunt for food";
                } else if (items.contains("container")) {
                    action = "Collect berries";
                } else {
                    action = "Explore";
                }
            } else if (environment.equals("desert")) {
                if (items.contains("hat")) {
                    action = "Search for water";
                } else {
                    action = "Find shade";
                }
            }
        } else if (timeOfDay.equals("night")) {
            if (environment.equals("forest")) {
                if (items.contains("firestarter")) {
                    action = "Make a campfire";
                } else {
                    action = "Climb a tree";
                }
            } else if (environment.equals("desert")) {
                if (items.contains("blanket")) {
                    action = "Sleep";
                } else {
                    action = "Keep moving to stay warm";
                }
            }
        }

        System.out.println(action);

    }
}

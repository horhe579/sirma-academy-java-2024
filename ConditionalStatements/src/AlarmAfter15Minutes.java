import java.util.Scanner;

public class AlarmAfter15Minutes {

    //generate a function to calculate the time after 15 minutes
    public static void calculateTime(int hours, int minutes) {
        int newHours = hours;
        int newMinutes = minutes + 15;

        if (newMinutes >= 60) {
            newHours++;
            newMinutes -= 60;
        }

        if (newHours >= 24) {
            newHours -= 24;
        }

        System.out.printf("%d:%02d", newHours, newMinutes);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        scanner.close();

        calculateTime(hours, minutes);
    }
}

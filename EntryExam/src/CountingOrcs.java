import java.util.Scanner;

public class CountingOrcs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Initial count of orcs:");
                int initialCount = Integer.parseInt(sc.nextLine());
                if (initialCount < 0) {
                    throw new IllegalArgumentException("Initial count of orcs cannot be negative.");
                }

                System.out.println("Increase of orcs per hour:");
                int increase = Integer.parseInt(sc.nextLine());

                System.out.println("Hours spent fighting orcs:");
                int hours = Integer.parseInt(sc.nextLine());
                if (hours < 0) {
                    throw new IllegalArgumentException("Number of hours cannot be negative.");
                }
                System.out.println(calculateFallenOrcs(initialCount, increase, hours));
                System.out.println(calculateFallenOrcsUsingMyBrain(initialCount, increase, hours));
                sc.close();
                return;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static int calculateFallenOrcs(int initialCount, int increase, int hours) {
        if (initialCount < 0) {
            throw new IllegalArgumentException("Initial count of orcs cannot be negative.");
        }
        if (hours < 0) {
            throw new IllegalArgumentException("Number of hours cannot be negative.");
        }
        int orcCount = 0;
        for (int i = 0; i < hours; i++, initialCount += increase) {
            orcCount += initialCount;
        }
        return orcCount;
    }

    public static int calculateFallenOrcsUsingMyBrain(int initialCount, int increase, int hours) {
        if (initialCount < 0) {
            throw new IllegalArgumentException("Initial count of orcs cannot be negative.");
        }
        if (hours < 0) {
            throw new IllegalArgumentException("Number of hours cannot be negative.");
        }
        int orcCount = 0;

        return orcCount = initialCount+increase*hours;
    }


}

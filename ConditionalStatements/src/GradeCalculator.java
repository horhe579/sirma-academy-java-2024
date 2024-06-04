import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int percentageScore = Integer.parseInt(scanner.nextLine());
        scanner.close();

        if (percentageScore >= 90) {
            System.out.println("A");
        } else if (percentageScore >= 80) {
            System.out.println("B");
        } else if (percentageScore >= 70) {
            System.out.println("C");
        } else if (percentageScore >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}

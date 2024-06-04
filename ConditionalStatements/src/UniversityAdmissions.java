import java.util.Scanner;

public class UniversityAdmissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = Integer.parseInt(scanner.nextLine());
        int activities = Integer.parseInt(scanner.nextLine());
        scanner.close();

        if(score >= 90)
        {
            System.out.println("Admitted");
        }
        else if(score >= 80 && activities >= 2)
        {
            System.out.println("Admitted");
        }
        else
        {
            System.out.println("Not admitted");
        }
    }
}

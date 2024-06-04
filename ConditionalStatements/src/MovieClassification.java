import java.util.Scanner;

public class MovieClassification{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        String movieCategory = "";
        scanner.close();

        if (age < 13)
        {
            movieCategory = "U-rated movies";
        } else if (age >= 13 && age <= 17)
        {
            movieCategory = "U and PG-13 rated movies";
        } else
        {
            movieCategory = "All movies";
        }

        System.out.println(movieCategory);
    }
}

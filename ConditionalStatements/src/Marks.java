import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            float grade = Float.parseFloat(scanner.nextLine());

            if(grade >= 2.0 && grade <= 6.0)
            {
                if(grade >= 5.5)
                {
                    System.out.println("Excellent!");
                }
                break;
            }
        }
        scanner.close();
    }
}

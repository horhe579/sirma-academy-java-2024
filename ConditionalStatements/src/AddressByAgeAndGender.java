import java.util.Scanner;

public class AddressByAgeAndGender {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);

        if (gender == 'f') {
            if (age <= 16) {
                System.out.println("Miss");
            } else {
                System.out.println("Ms.");
            }
        } else {
            if (age <= 16) {
                System.out.println("Master");
            } else {
                System.out.println("Mr.");
            }
        }
        scanner.close();
    }
}

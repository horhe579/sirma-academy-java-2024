import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //car1 speed
        int x = Integer.parseInt(scanner.nextLine());
        //car2 speed
        int y = Integer.parseInt(scanner.nextLine());

        //distance between cars
        System.out.println(x*5-y*3);
    }
}
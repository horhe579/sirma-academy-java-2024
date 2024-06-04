import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double money = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double lightsabrePrice = Double.parseDouble(sc.nextLine());
        double robePrice = Double.parseDouble(sc.nextLine());
        double beltPrice = Double.parseDouble(sc.nextLine());

        sc.close();

        double total = lightsabrePrice * Math.ceil(students * 1.1) +
                robePrice * students +
                beltPrice * (students - students / 6);

        System.out.printf(
                total <= money
                        ? "The money is enough - it would cost %.2f lv.%n"
                        : "George Lucas will need %.2f lv more.%n",
                total <= money
                        ? total
                        : total - money
        );
    }
}

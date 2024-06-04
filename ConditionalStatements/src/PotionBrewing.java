import java.util.Scanner;

public class PotionBrewing{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ingredient1 = scanner.nextLine().toLowerCase();
        String ingredient2 = scanner.nextLine().toLowerCase();
        String potion = "";
        scanner.close();

        if (ingredient1.equals("herbs") || ingredient2.equals("herbs")) {
            if (ingredient2.equals("water") ) {
                potion = "Health potion";
            } else if (ingredient2.equals("oil")) {
                potion = "Stealth potion";
            } else {
                potion = "Minor stamina potion";
            }
        } else if (ingredient1.equals("berries")) {
            if (ingredient2.equals("sugar")) {
                potion = "Speed potion";
            } else {
                potion = "Minor energy potion";
            }
        } else {
            potion = "No potion";
        }

        System.out.println(potion);

    }
}

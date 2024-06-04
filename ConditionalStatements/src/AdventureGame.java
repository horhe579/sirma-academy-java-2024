import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rightHandTool = scanner.nextLine().toLowerCase();
        String leftHandTool = scanner.nextLine().toLowerCase();
        scanner.close();

        String path = "";

        if (rightHandTool.equals("sword") || leftHandTool.equals("sword")) {
            if (leftHandTool.equals("shield") || rightHandTool.equals("shield")) {
                path = "Path to the castle";
            } else {
                path = "Path to the forest";
            }
        } else if (rightHandTool.equals("map") || leftHandTool.equals("map")) {
            if (leftHandTool.equals("coins") || rightHandTool.equals("coins")) {
                path = "Go to the town";
            } else {
                path = "Camp";
            }
        } else {
            path = "Wander aimlessly";
        }

        System.out.println(path);

    }
}

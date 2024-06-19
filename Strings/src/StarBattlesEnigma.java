import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarBattlesEnigma {

    public final static Pattern messagePattern = Pattern.compile("@(?<planetName>\\w+):(?<population>\\d+)!(?<attackType>A|D)!->(?<soldierCount>\\d+)");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<String> attackedPlanets = new ArrayList<>();
        ArrayList<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String encryptedMessage = sc.nextLine();
            String decryptedMessage = decryptLegendaryStarEnigma(encryptedMessage);
            parseLegendaryStarEnigma(decryptedMessage, attackedPlanets, destroyedPlanets);
        }

        printPlanets(attackedPlanets, destroyedPlanets);
    }

    private static String decryptLegendaryStarEnigma(String message) {
        int count = 0;
        for (char c : message.toLowerCase().toCharArray()) {
            if (c == 's' || c == 't' || c == 'a' || c == 'r') {
                count++;
            }
        }
        StringBuilder decryptedMessage = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            decryptedMessage.append((char) ((int) message.toCharArray()[i] - count));
        }
        return decryptedMessage.toString();
    }

    private static void parseLegendaryStarEnigma(String decryptedMessage, ArrayList<String> attacked, ArrayList<String> destroyed) {
        Matcher matcher = messagePattern.matcher(decryptedMessage);

        if (!matcher.find()) {
            System.err.println("Invalid formatting for message " + decryptedMessage);
            return;
        }
        if (!(matcher.group("attackType").equals("A") || matcher.group("attackType").equals("D"))) {
            System.err.println("Invalid attack type for message " + decryptedMessage);
            return;
        }

        switch (matcher.group("attackType")) {
            case "A":
                attacked.add(matcher.group("planetName"));
                break;
            case "D":
                destroyed.add(matcher.group("planetName"));
                break;
        }
    }

    private static void printPlanets(ArrayList<String> attacked, ArrayList<String> destroyed) {
        System.out.println("Attacked planets: " + attacked.size());
        for (String planet : attacked) {
            System.out.println("-> " + planet);
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        for (String planet : destroyed) {
            System.out.println("-> " + planet);
        }
    }
}

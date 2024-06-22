import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StarBattlesEnigma {

    private final static Pattern messagePattern = Pattern.compile("@(?<planetName>\\w+):(?<population>\\d+)!(?<attackType>A|D)!->(?<soldierCount>\\d+)");
    private final static HashSet<Character> enigmaLetters = new HashSet<>();

    static {
        enigmaLetters.add('s');
        enigmaLetters.add('t');
        enigmaLetters.add('a');
        enigmaLetters.add('r');
    }


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
        long count = message.toLowerCase(Locale.US).chars()
                .mapToObj(c -> (char) c)
                .filter(enigmaLetters::contains)
                .count();

        return message.chars().map(c -> c - (int) count)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining(""));
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

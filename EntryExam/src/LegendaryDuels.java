import java.util.ArrayDeque;
import java.util.Scanner;

public class LegendaryDuels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String duel = sc.nextLine();
            isLegendaryDuel(duel);
            sc.close();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(STR."An unexpected error occurred: \{e.getMessage()}");
        } finally {
            sc.close();
        }
//        isLegendaryDuel("()()(()())");
//        isLegendaryDuel("((!!)(({!!})))");
//        isLegendaryDuel("((())");
//        isLegendaryDuel("{!}!");
//        isLegendaryDuel("({(!!}))");
//        isLegendaryDuel("!()!");
//        isLegendaryDuel("{!}!*");
    }

    public static void isLegendaryDuel(String duel) {

        ArrayDeque<String> strikes = new ArrayDeque<>();
        boolean notLegendary = false;
        int powerStrikeCount = 0;
        for (String s : duel.split("")) {
            switch (s) {
                case ")":
                case "}":
                    if (((int) strikes.pop().charAt(0) + ((s.equals(")")) ? 1 : 2)) != (int) s.charAt(0)) {
                        notLegendary = true;
                    }
                    break;
                case "{":
                case "(":
                    strikes.push(s);
                    break;
                case "!":
                    strikes.push(s);
                    powerStrikeCount++;
                    if (powerStrikeCount % 2 == 0) {
                        if (!strikes.pop().equals(strikes.pop())) {
                            notLegendary = true;
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException(STR."Invalid strike - \{s}.");
            }
        }
        System.out.println((notLegendary == true || !strikes.isEmpty())
                ? "Not Legendary"
                : "Legendary");
    }
}

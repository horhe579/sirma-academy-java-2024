import java.util.*;

public class WarGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read and prepare the decks for both players
        Set<Integer> uniqueDeck1 = new LinkedHashSet<>(Arrays.asList(Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new)));
        Set<Integer> uniqueDeck2 = new LinkedHashSet<>(Arrays.asList(Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new)));

        // Create deques for both players
        ArrayDeque<Integer> deck1 = new ArrayDeque<>(uniqueDeck1);
        ArrayDeque<Integer> deck2 = new ArrayDeque<>(uniqueDeck2);

        int rounds = 50;
        while (rounds > 0 && !deck1.isEmpty() && !deck2.isEmpty()) {
            rounds--;

            // Players draw the top card
            int card1 = deck1.poll();
            int card2 = deck2.poll();

            if (card1 > card2) {
                // First player wins the round
                deck1.add(card1);
                deck1.add(card2);
            } else if (card2 > card1) {
                // Second player wins the round
                deck2.add(card2);
                deck2.add(card1);
            }
            // If card1 == card2, both cards are discarded (no action needed)
        }

        // Determine the result
        if (deck1.isEmpty() && deck2.isEmpty()) {
            System.out.println("Draw!");
        } else if (deck1.isEmpty()) {
            System.out.println("Second player wins!");
        } else if (deck2.isEmpty()) {
            System.out.println("First player wins!");
        } else {
            // Both players still have cards after 50 rounds
            System.out.println("Draw!");
        }
    }
}

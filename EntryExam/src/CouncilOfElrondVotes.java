import java.util.Scanner;

public class CouncilOfElrondVotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String[] votes = sc.nextLine().split("[, ]+");
            determineCouncilDecision(votes);
        } catch (IllegalArgumentException e) {
            System.err.println(STR."Argument exception: \{e.getMessage()}");
        } catch (Exception e) {
            System.err.println(STR."An unexpected error occured: \{e.getMessage()}");
        } finally {
            sc.close();
        }
    }

    public static void determineCouncilDecision(String[] votes) {
        int yesCount = 0, noCount = 0, abstainCount = 0;

        if (votes.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }
        for (String vote : votes) {
            switch (vote.toLowerCase()) {
                case "yes" -> yesCount++;
                case "no" -> noCount++;
                case "abstain" -> abstainCount++;
                default -> throw new IllegalArgumentException(STR."Unknown vote format for vote \"\{vote}\".");
            }
        }

        System.out.println(
                (yesCount > noCount)
                        ? "Yes"
                        : (yesCount < noCount)
                        ? "No"
                        : (abstainCount > 0 && yesCount == 0 && noCount == 0)
                        ? "Abstain"
                        : "Tie"
        );
    }
}

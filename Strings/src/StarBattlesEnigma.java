import java.util.ArrayList;
import java.util.Scanner;

public class StarBattlesEnigma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<String> attackedPlanets = new ArrayList<>();
        ArrayList<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String encryptedMessage = sc.nextLine();
            System.out.println(decryptLegendaryStarEnigma(encryptedMessage));
        }
    }

    private static String decryptLegendaryStarEnigma(String message) {
        int count = 0;
        for(char c : message.toLowerCase().toCharArray())
        {
            if(c == 's' || c == 't' || c== 'a' || c == 'r')
            {
                count++;
            }
        }
        StringBuilder decryptedMessage = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            decryptedMessage.append((char) ((int) message.toCharArray()[i] - count));
        }
        return decryptedMessage.toString();
    }

    private static void parseLegendaryStarEnigma(String decryptedMessage, ArrayList<String> attacked, ArrayList<String> destroyed)
    {

    }
}

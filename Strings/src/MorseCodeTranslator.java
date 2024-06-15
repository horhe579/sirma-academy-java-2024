import java.util.HashMap;
import java.util.Scanner;

public class MorseCodeTranslator {

    private static final HashMap<String, Character> morseCodeTable = new HashMap<>();

    static {
        morseCodeTable.put(".-", 'A');
        morseCodeTable.put("-...", 'B');
        morseCodeTable.put("-.-.", 'C');
        morseCodeTable.put("-..", 'D');
        morseCodeTable.put(".", 'E');
        morseCodeTable.put("..-.", 'F');
        morseCodeTable.put("--.", 'G');
        morseCodeTable.put("....", 'H');
        morseCodeTable.put("..", 'I');
        morseCodeTable.put(".---", 'J');
        morseCodeTable.put("-.-", 'K');
        morseCodeTable.put(".-..", 'L');
        morseCodeTable.put("--", 'M');
        morseCodeTable.put("-.", 'N');
        morseCodeTable.put("---", 'O');
        morseCodeTable.put(".--.", 'P');
        morseCodeTable.put("--.-", 'Q');
        morseCodeTable.put(".-.", 'R');
        morseCodeTable.put("...", 'S');
        morseCodeTable.put("-", 'T');
        morseCodeTable.put("..-", 'U');
        morseCodeTable.put("...-", 'V');
        morseCodeTable.put(".--", 'W');
        morseCodeTable.put("-..-", 'X');
        morseCodeTable.put("-.--", 'Y');
        morseCodeTable.put("--..", 'Z');
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] morseCodeMessage = sc.nextLine().split("\\|");
            StringBuilder decodedMessage = new StringBuilder(morseCodeMessage.length);

            for (int i = 0; i < morseCodeMessage.length; i++) {
                String[] messageLetters = morseCodeMessage[i].split("\\s+");
                for (int j = 0; j < messageLetters.length; j++) {
                    if (!morseCodeTable.containsKey(messageLetters[j])) {
                        continue;
                    }
                    decodedMessage.append(morseCodeTable.get(messageLetters[j]));
                }
                decodedMessage.append(" ");
            }

            System.out.println(decodedMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

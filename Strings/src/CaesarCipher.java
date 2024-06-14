import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        StringBuilder encryptedMessage = new StringBuilder(message.length());

        for(char c : message.toCharArray())
        {
            encryptedMessage.append((char)(c + 3));
        }

        System.out.println(encryptedMessage.toString());
    }
}

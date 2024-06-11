import java.util.Scanner;

public class ElvishCodeCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = "";
        int shift = 0;

        while (true) {
            System.out.println("Enter the message (1-100 characters):");
            message = sc.nextLine();
            if (message.length() >= 1 && message.length() <= 100) {
                break;
            } else {
                System.out.println("Invalid message length. Please enter a message with 1-100 characters.");
            }
        }

        while (true) {
            System.out.println("Enter the shift value (1-25):");
            try {
                shift = Integer.parseInt(sc.nextLine());
                if (shift >= 1 && shift <= 25) {
                    break;
                } else {
                    System.out.println("Invalid shift value. Please enter a value between 1 and 25.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer value.");
            }
        }

        sc.close();
        System.out.println(decryptMessage(message, shift));
    }

    public static String decryptMessage(String message, int shift) {
        if (message.length() == 0) {
            throw new IllegalArgumentException("Message must be at least one character.");
        }
        char[] decryptedMessage = message.toCharArray();

        for (int i = 0; i < decryptedMessage.length; i++) {
            decryptedMessage[i] = (char) (decryptedMessage[i] - shift);
        }

        return String.valueOf(decryptedMessage);
    }
}

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] words = sc.nextLine().split("\\s+");
        StringBuilder repeatedString = new StringBuilder();

        for(String text : words)
        {
            for (int i = 0; i < text.length(); i++) {
                repeatedString.append(text);
            }
        }

        System.out.println(repeatedString.toString());
    }
}

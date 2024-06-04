import java.util.Scanner;

public class LettersInAWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();

        for(char c : word.toCharArray()) {
            System.out.println(c);
        }
    }
}

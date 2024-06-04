import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String reversed = "";
        sc.close();

        for(int i = word.length()- 1; i >= 0; i--)
        {
            reversed = reversed + word.charAt(i);
        }
        if(reversed.equals(word))
        {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

        
    }
}

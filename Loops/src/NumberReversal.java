import java.util.Scanner;

public class NumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        for(int i = String.valueOf(n).length()- 1; i >= 0; i--)
        {
            System.out.print(String.valueOf(n).charAt(i));
        }
    }
}

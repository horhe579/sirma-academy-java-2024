import java.util.Scanner;


public class ReverseStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String text = sc.nextLine();
            switch (text) {
                case "end":
                    sc.close();
                    return;
                default:
                    System.out.print(STR."\{text} = ");
                    for (int i = text.length() - 1; i >= 0; i--) {
                        System.out.print(text.charAt(i));
                        if(i == 0)
                        {
                            System.out.println();
                        }
                    }
            }
        }

    }
}

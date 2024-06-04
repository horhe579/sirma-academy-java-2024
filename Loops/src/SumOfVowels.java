import java.util.Scanner;

public class SumOfVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();

        int sum = 0;

        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            switch(c)
            {
                case 'u':
                    sum += 5;
                    break;
                case 'o':
                    sum += 4;
                    break;
                case 'i':
                    sum += 3;
                    break;
                case 'e':
                    sum += 2;
                    break;
                case 'a':
                    sum ++;
                    break;
            }
        }
        System.out.println(sum);
    }
}

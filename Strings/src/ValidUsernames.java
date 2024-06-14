import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] names = sc.nextLine().split("[, ]+");

        Pattern pattern = Pattern.compile("[A-Za-z-_\\d]{3,16}");

        for(String username: names)
        {
            Matcher matcher = pattern.matcher(username);
            if(matcher.matches())
            {
                System.out.println(username);
            }
        }
    }

}

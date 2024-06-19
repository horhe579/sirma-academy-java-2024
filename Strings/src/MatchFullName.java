import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        //regex /(\b([A-Z]{1}[a-z]{1,}) ([A-Z]{1}[a-z]{2,})\b)/gm

        Scanner sc = new Scanner(System.in);

        String [] fullNames = sc.nextLine().split("[,]+");

        Pattern fullNamePattern = Pattern.compile("(\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b)");
        for(String fullName : fullNames)
        {
            Matcher matcher = fullNamePattern.matcher(fullName);
            if(matcher.find())
            {
                System.out.print(matcher.group() + " ");
            }
        }

        sc.close();

    }
}

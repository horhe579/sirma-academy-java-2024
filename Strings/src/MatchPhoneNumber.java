import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] phoneNumbers = sc.nextLine().split("[,]+");

        String phoneNumberRegex = "(?<!\\\\S)\\\\+359([ -])2\\\\1\\\\d{3}\\\\1\\\\d{4}\\\\b";
        Pattern phoneNumberPatter = Pattern.compile(phoneNumberRegex);

        for(String phoneNumber : phoneNumbers)
        {
            Matcher matcher = phoneNumberPatter.matcher(phoneNumber.trim());
            if(matcher.matches())
            {
                System.out.println(phoneNumber);
            }
        }
    }
}

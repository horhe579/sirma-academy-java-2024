import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] dates = sc.nextLine().split(",+");

        String dateRegex = "(?<day>\\d{2})([\\.|\\-|\\/])(?<month>[A-Z][a-z]{2})()\\2(?<year>\\d{4})";
        Pattern datePattern = Pattern.compile(dateRegex);

        for(String date: dates)
        {
            Matcher matcher = datePattern.matcher(date.trim());
            if(matcher.matches())
            {
                String day = matcher.group("day");
                String month = matcher.group("month");
                String year = matcher.group("year");
                System.out.println("Day: " + day + ", Month: " + month + ", Year: " + year);
            }
        }
        sc.close();

    }
}

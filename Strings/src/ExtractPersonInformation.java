import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String nameRegex = "(?<=\\@)(.*?)(?=\\|)";
        String ageRegex = "(?<=\\#)(.*?)(?=\\*)";
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern agePattern = Pattern.compile(ageRegex);

        for (int i = 0; i < n; i++) {
            String text = sc.nextLine();
            Matcher nameMatcher = namePattern.matcher(text);
            Matcher ageMatcher = agePattern.matcher(text);

            if (nameMatcher.find() && ageMatcher.find()) {
                System.out.println(nameMatcher.group() + " is " + ageMatcher.group() + " years old.");
            } else {
                System.out.println("No match found in the provided input.");
            }        }
    }
}

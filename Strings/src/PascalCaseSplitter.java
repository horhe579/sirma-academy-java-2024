import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PascalCaseSplitter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pascalCaseString = sc.nextLine();

        int lastUpperLetterIndex = Integer.MIN_VALUE;
        Pattern pascalCaseStart = Pattern.compile("[A-Z]");
        StringBuilder outputString = new StringBuilder();

        Matcher pascalCaseStartMatcher = pascalCaseStart.matcher(pascalCaseString);
        while (true) {
            if (pascalCaseStartMatcher.find()) {
                if(lastUpperLetterIndex >= 0)
                {
                    outputString.append(pascalCaseString.substring(lastUpperLetterIndex, pascalCaseStartMatcher.end()-1));
                    outputString.append(", ");
                }
                lastUpperLetterIndex = pascalCaseStartMatcher.end()-1;
            }
            else
            {
                break;
            }
        }

        outputString.append(pascalCaseString.substring(lastUpperLetterIndex));
        System.out.println(outputString);

    }
}

import java.util.Arrays;
import java.util.Scanner;

public class AddAndRemove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] inputCommands = sc.nextLine().split("[, ]+");
        String finalArrCopy = "";
        StringBuilder finalArr = new StringBuilder();
        int numToAdd = 1;

        for (int i = 0; i < inputCommands.length; i++) {
            if(inputCommands[i].equals("add"))
            {
                finalArrCopy = finalArr.toString();
                finalArr.append(numToAdd).append(" ");
                numToAdd++;
            } else if (inputCommands[i].equals("remove")) {
                finalArr = new StringBuilder(finalArrCopy);
            }
        }

        if(finalArr.length() > 0)
        {
            int [] cloneArr = Arrays.stream(finalArr.toString().split("[, ]+"))
                    .mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(cloneArr));
        }
        else {
            System.out.println("Empty");
        }
    }
}

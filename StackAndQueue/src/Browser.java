import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> prevURLs = new ArrayDeque();
        ArrayDeque<String> nextURLs = new ArrayDeque();
        String input = sc.nextLine();

        while (!input.equals("Home")) {
            if (input.toLowerCase().equals("back")) {
                if(prevURLs.isEmpty())
                {
                    System.out.println("no prev");
                }
                else{
                    nextURLs.push(prevURLs.pop());
                    System.out.println((prevURLs.isEmpty()) ? "no prev" : prevURLs.peek());
                }
            } else if (input.toLowerCase().equals("next")) {
                if(nextURLs.isEmpty())
                {
                    System.out.println("no next");
                }
                else{
                    System.out.println(nextURLs.peek());
                    prevURLs.push(nextURLs.pop());
                }

            } else {
                if(prevURLs.isEmpty())
                {
                    nextURLs.clear();
                }
                prevURLs.push(input);
                System.out.println(prevURLs.peek());
            }
            input = sc.nextLine();
        }
    }
}

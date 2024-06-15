import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            String title = sc.nextLine();
            String content = sc.nextLine();
            String comment = "";

            StringBuilder article = new StringBuilder();

            if (title.isEmpty() || title.isBlank()) {
                throw new RuntimeException("Title cannot be blank or empty.");
            }

            article.append(String.format("<h1>\n\t%s\n</h1>\n", title));
            article.append(String.format("<article>\n\t%s\n</article>\n", content));

            while (true) {
                comment = sc.nextLine();
                if (comment.toLowerCase().equals("end of comments")) {
                    System.out.println(article);
                    return;
                }
                article.append(String.format("<div>\n\t%s\n</div>\n", comment));
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

    }
}

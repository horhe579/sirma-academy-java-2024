import Classes.Article;

import java.util.Scanner;

public class ArticleExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] articleDetails = sc.nextLine().split("[,]");
        int n = Integer.parseInt(sc.nextLine());
        Article article = new Article(articleDetails[0].trim(), articleDetails[1].trim(), articleDetails[2].trim());
        for (int i = 0; i < n; i++) {
            String command[] = sc.nextLine().split(":", 2);
            switch (command[0].toLowerCase().trim())
            {
                case "edit":
                    System.out.println(article);
                    article.edit(command[1]);
                    System.out.println(article);
                    break;
                case "changeauthor":
                    System.out.println(article);
                    article.changeAuthor(command[1]);
                    System.out.println(article);
                    break;
                case "rename":
                    System.out.println(article);
                    article.rename(command[1]);
                    System.out.println(article);
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}

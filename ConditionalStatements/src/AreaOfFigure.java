import java.util.Scanner;

public class AreaOfFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();

        switch (figure)
        {
            case "square":
                double side = Double.parseDouble(scanner.nextLine());
                System.out.println(String.format("%.2f",side * side));
                break;
            case "rectangle":
                double width = Double.parseDouble(scanner.nextLine());
                double height = Double.parseDouble(scanner.nextLine());
                System.out.println(String.format("%.2f",width * height));
                break;
            case "circle":
                double radius = Double.parseDouble(scanner.nextLine());
                System.out.println(String.format("%.2f",Math.PI * radius * radius));
                break;
            case "triangle":
                double base = Double.parseDouble(scanner.nextLine());
                double heightTriangle = Double.parseDouble(scanner.nextLine());
                System.out.println(String.format("%.2f",base * heightTriangle / 2));
                break;
            default:
                System.out.println("Invalid figure");
                break;

        }
        scanner.close();
    }
}

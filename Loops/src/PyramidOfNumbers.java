import java.util.Scanner;

public class PyramidOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
        int currentNumber = 1;
        int rowLength = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= rowLength; j++) {
                if (currentNumber > n) {
                    return;
                }
                System.out.print(currentNumber + " ");
                currentNumber++;
            }
            System.out.println();
            rowLength++;
        }
    }
}

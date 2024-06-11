import java.util.Scanner;

public class CheckerboardPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, rows);

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(
                        (i % 2 == 0)
                        ? (j % 2 == 0)
                                ? "0 "
                                : "1 "
                        : (j % 2 == 0)
                                ? "1 "
                                : "0 "
                );

                if(j == matrix[i].length - 1)
                {
                    System.out.println();
                }
            }
        }

    }
}

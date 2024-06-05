import java.util.Scanner;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, rows);
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            sum += matrix[i][i];
        }

        for (int i = rows-1; i >= 0; i--) {
            sum += matrix[i][i];
        }
        System.out.println(sum);
    }
}

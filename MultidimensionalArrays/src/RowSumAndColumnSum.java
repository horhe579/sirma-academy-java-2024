import java.util.Arrays;
import java.util.Scanner;

public class RowSumAndColumnSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, cols);
        rowAndColumnSum(matrix);
    }

    public static void rowAndColumnSum(int[][] matrix)
    {
        int[] rowSums = new int[matrix.length];
        int[] colSums = new int[matrix[0].length];
        int rowSum = 0;
        int colSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum+=matrix[i][j];
                rowSums[i] = rowSum;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            colSum = 0;
            for (int j = 0; j < matrix.length; j++) {
                colSum+=matrix[j][i];
                colSums[i] = colSum;
            }
        }
        System.out.println(Arrays.toString(rowSums));
        System.out.println(Arrays.toString(colSums));

    }
}

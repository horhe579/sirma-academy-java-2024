import java.util.Scanner;

public class MagicSquareChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, rows);
        System.out.println(isMagicSquare(matrix));
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int[] rowSums = new int[matrix.length];
        int[] colSums = new int[matrix[0].length];
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Matrix must be a square.");
        }
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            leftDiagonalSum += matrix[i][i];
            rightDiagonalSum += matrix[matrix.length - i - 1][matrix[i].length - i - 1];
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            rowSums[i] = rowSum;
            colSums[i] = colSum;
        }
        if(leftDiagonalSum != rightDiagonalSum)
        {
            return false;
        }
        for (int i = 0; i < rowSums.length; i++) {
            for (int j = 0; j < colSums.length; j++) {
                if((rowSums[i] != colSums[j])
                        || (rowSums[i] != leftDiagonalSum)
                        || (colSums[i] != leftDiagonalSum))
                {
                    return false;
                }
            }
        }
        return true;
    }
}

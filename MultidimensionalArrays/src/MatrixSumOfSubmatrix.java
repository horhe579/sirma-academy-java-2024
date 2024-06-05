import java.util.Scanner;

public class MatrixSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, cols);

        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int subMatrixSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (max < subMatrixSum) {
                    max = subMatrixSum;
                }
            }
        }
        System.out.println(max);
    }
}

import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, cols);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int subMatrixSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (max < subMatrixSum) {
                    max = subMatrixSum;
                }
            }
        }
        System.out.println(max);
    }

}

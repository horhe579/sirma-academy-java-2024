import java.util.Arrays;
import java.util.Scanner;

public class RotateMatrix90Deg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, rows);
        rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    public static void rotateMatrix(int[][] matrix) {
        int[][] matrixClone = cloneMatrix(matrix);
        for (int j = 0; j < matrix[0].length; j++) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[j][k] = matrixClone[matrix.length - 1 - k][j];
            }
        }
    }

    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] matrixClone = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixClone[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return matrixClone;
    }
}

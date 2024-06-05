import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static final int matrixLimit = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<int[][]> matrices = new ArrayList<>();

        for (int i = 0; i < matrixLimit; i++) {
            int [] matrixDimensions = Arrays.stream(sc.nextLine().split("[, ]+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrices.add(createMatrix(matrixDimensions[0], matrixDimensions[1]));
        }

        System.out.println(compareMatrices(matrices.get(0), matrices.get(1)));
    }

    public static int[][] createMatrix(int rows, int cols)
    {
        Scanner sc = new Scanner(System.in);
        int [][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] rowElements = Arrays.stream(sc.nextLine().split("[, ]+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rowElements[j];
            }
        }
        return matrix;
    }

    public static boolean compareMatrices(int[][] matrix1, int[][] matrix2)
    {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length)
        {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if(matrix1[i][j] != matrix2[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}

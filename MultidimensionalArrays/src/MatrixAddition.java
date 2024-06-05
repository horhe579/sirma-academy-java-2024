import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] matrixDimensions = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer [][]> matrices = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            matrices.add(CompareMatrices.createMatrix(matrixDimensions[0], matrixDimensions[1]));
        }

        Integer [][] newMatrix = matrixSum(matrices.get(0), matrices.get(1));
        System.out.println(Arrays.deepToString(newMatrix));
    }

    public static Integer[][] matrixSum(Integer[][] matrix1, Integer[][] matrix2)
    {
        Integer [][] newMatrix = new Integer[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                newMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return newMatrix;
    }

}

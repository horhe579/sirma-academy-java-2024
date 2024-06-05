import java.util.Scanner;

public class MatrixBoundarySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int [][] matrix = CompareMatrices.createMatrix(rows, cols);
        System.out.println(calculateBoundarySum(matrix));
    }

    public static int calculateBoundarySum(int [][] matrix)
    {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if((i == 0 || i == matrix.length-1))
                {
                    sum+=matrix[i][j];
                }
                if(i != 0 && i != matrix.length-1 && (j == 0 || j == matrix[0].length -1 ))
                {
                    sum+=matrix[i][j];
                }
            }
        }
        return sum;
    }
}

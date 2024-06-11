import java.util.Scanner;


public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, cols);


    }

    public static void printSpiralMatrix(int [][] matrix)
    {

    }

    public static void printMatrixRow(int [][] matrix, int row)
    {
        for (int i = 0; i < matrix[i].length; i++) {
            System.out.print(STR."\{matrix[row][i]} ");
        }
    }

    public static void printMatrixRowSpiral(int [][] matrix, int row)
    {
        //if(matrix[row].length )
    }
}

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        Integer[][] matrix = CompareMatrices.createMatrix(rows, rows);

        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        for (int i = rows-1; i >= 0; i--) {
            System.out.print(matrix[i][i] + " ");
        }

    }
}

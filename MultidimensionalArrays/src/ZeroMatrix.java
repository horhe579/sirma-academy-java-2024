import java.util.*;

public class ZeroMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int [][] matrix = CompareMatrices.createMatrix(rows, cols);
        Set<Integer> rowsToAnnulate = new HashSet<>();
        Set<Integer> colsToAnnulate = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0)
                {
                    rowsToAnnulate.add(i);
                    colsToAnnulate.add(j);
                }
            }
        }

        rowsToAnnulate.stream().forEach(r -> annulateRow(matrix, r));
        colsToAnnulate.stream().forEach(c -> annulateCol(matrix, c));

        System.out.println(Arrays.deepToString(matrix));

    }

    public static void annulateRow(int [][] matrix, int row)
    {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void annulateCol(int [][] matrix, int col)
    {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}

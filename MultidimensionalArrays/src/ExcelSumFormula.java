import java.util.Scanner;

public class ExcelSumFormula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int[][] matrix = CompareMatrices.createMatrix(rows, cols);
        String start = sc.nextLine().toLowerCase();
        String end = sc.nextLine().toLowerCase();
        int startingRow = start.toCharArray()[0] - 'a';
        int startingCol = Character.getNumericValue(start.toCharArray()[1]) - 1;
        int endingRow = end.toCharArray()[0] - 'a';
        int endingCol = Character.getNumericValue(end.toCharArray()[1]) - 1;

        int sum = 0;
        for (int i = startingRow; i <= endingRow; i++) {
            if (i == startingRow) {
                for (int j = startingCol; j < matrix[i].length; j++) {
                    sum+=matrix[i][j];
                }
            } else if (i == endingRow) {
                for (int j = 0; j <= endingCol; j++) {
                    sum+=matrix[i][j];
                }
                System.out.println(sum);
                return;
            }
            else
            {
                for (int j = 0; j < matrix[i].length; j++) {
                    sum+=matrix[i][j];
                }
            }
        }

    }
}

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String [] pattern = sc.nextLine().split("[, ]+");
        int rows = Integer.parseInt(pattern[0]);
        String patternLetter = pattern[1];

        int[][] matrix = new int[rows][rows];
        switch (patternLetter.toLowerCase())
        {
            case "a":
                matrix = createPatternAMatrix(rows);
                break;
            case "b":
                matrix = createPatternBMatrix(rows);
                break;
        }
        System.out.println(Arrays.deepToString(matrix));

    }

    public static int[][] createPatternAMatrix(int rows) {
        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = (j == 0)
                        ? i + 1
                        : matrix[i][j - 1] + rows;
            }
        }
        return matrix;
    }

    public static int[][] createPatternBMatrix(int rows)
    {
        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = (j == 0)
                        ? i + 1
                        : (j % 2 == 0)
                        ? matrix[i][j-1] + 2 + i*j - 1
                        : rows*(j+1) - i;
            }
        }
        return matrix;
    }
}

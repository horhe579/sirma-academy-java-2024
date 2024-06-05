import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] pattern = sc.nextLine().split("[, ]+");
        int rows = Integer.parseInt(pattern[0]);
        String patternLetter = pattern[1];

        int[][] matrix = createPatternMatrix(rows, patternLetter.trim());

        System.out.println(Arrays.deepToString(matrix));

    }

    public static int[][] createPatternMatrix(int rows, String pattern)
    {
        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if(j == 0)
                {
                    matrix[i][j] = i +1;
                }
                else
                {
                    switch (pattern.toLowerCase())
                    {
                        case "a":
                            matrix[i][j] = matrix[i][j - 1] + rows;
                            break;
                        case "b":
                            matrix[i][j] = (j % 2 == 0)
                                    ? matrix[i][j - 1] + 2 + i * j - 1
                                    : rows * (j + 1) - i;
                            break;
                    }
                }
            }
        }
        return matrix;
    }
}

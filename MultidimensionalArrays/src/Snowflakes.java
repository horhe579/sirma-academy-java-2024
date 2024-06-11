import java.util.Arrays;
import java.util.Scanner;

public class Snowflakes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        int rows = Integer.parseInt(sc.nextLine());
//        int cols = Integer.parseInt(sc.nextLine());

        String [][] matrix = {
                {"*", "0", "*"},
                {"0", "0", "0"},
                {"0", "0", "0"},
        };

        makeItRain(matrix);

    }

    public static void makeItRain(String [][] matrix)
    {
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("*"))
                {
                    if(!matrix[i+1][j].equals("#"))
                    {
                        String temp = matrix[i][j];
                        matrix[i][j] = matrix[i+1][j];
                        matrix[i+1][j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }

}

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int digitSum = 0;
        sc.close();

        for (int i = 0; i < String.valueOf(n).length(); i++)
        {
            int j = Character.getNumericValue(String.valueOf(n).charAt(i));
            digitSum += Math.pow((double)j, (double)String.valueOf(n).length());
        }
        System.out.println(n == digitSum);

    }
}

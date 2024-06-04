import java.util.Arrays;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] products = sc.nextLine().split("[, ]+");

        Arrays.sort(products);

        for(int i = 0; i < products.length; i++)
        {
            System.out.println(i+1 + "." + products[i]);
        }
    }
}

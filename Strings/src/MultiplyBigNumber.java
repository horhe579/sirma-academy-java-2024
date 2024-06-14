import java.util.Arrays;
import java.util.Scanner;

//shte ti eba maikata

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String largeNumber = sc.nextLine();
//        String notSoLargeNumber = sc.nextLine();

        //System.out.println(19/18);
        System.out.println(addNumbers("923847238931983192462832102", "4"));
        System.out.println(addNumbers("9999", "9"));
        System.out.println(addNumbers("23", "2"));


    }
    //long 19 chars

    private static String addNumbers(String a, String b)
    {
        if(a.length() > 18)
        {
            int fragmentCount = (int) Math.ceil(((double) a.length()/18));
            int fragmentLength = a.length()/fragmentCount;
            String [] fragments = new String[fragmentCount];

            for (int i = 0; i < fragmentCount; i++) {
                if(i == fragmentCount-1)
                {
                    fragments[i] = a.substring(i*fragmentLength);
                }
                else {
                    fragments[i] = a.substring(i*fragmentLength, (i+1)*fragmentLength);
                }
            }

            for(int i = 0; i<fragments.length; i++)
            {
                fragments[i] = String.valueOf(Long.parseLong(fragments[i]) * Long.parseLong(b));
            }

            String res = String.valueOf(Arrays.stream(fragments).mapToLong(Long::parseLong).reduce(0, Long::sum));
            return res;
        }
        return String.valueOf(Long.parseLong(a)*Long.parseLong(b));
    }
}

import java.util.Scanner;

public class EvenPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //first pair + second pair = loop start
        int firstPair = Integer.parseInt(sc.nextLine());
        int secondPair = Integer.parseInt(sc.nextLine());
        //(first pair + first pair diff) + (second pair + second pair diff) = loop end
        int firstPairValueDifference = Integer.parseInt(sc.nextLine());
        int secondPairValueDifference = Integer.parseInt(sc.nextLine());
        sc.close();

        int firstPairLimit = firstPair + firstPairValueDifference;
        int secondPairLimit = secondPair + secondPairValueDifference;


        for (int i = firstPair; i <= firstPairLimit; i++) {
            if (!IsPrime.isPrime(i)) continue;
            for (int j = secondPair; j <= secondPairLimit; j++) {
                if (!IsPrime.isPrime(j)) continue;
                System.out.printf("%d%d ", i, j);
            }
        }

//        for (int i = Integer.parseInt(String.valueOf(firstPair) + String.valueOf(secondPair));
//             i <= Integer.parseInt(String.valueOf(firstPair + firstPairValueDifference) + String.valueOf(secondPair + secondPairValueDifference));
//             i++) {
//
//            if (isPrime(i / 100)
//                    && (i / 100) <= Integer.parseInt(String.valueOf(firstPair + firstPairValueDifference)) && (i / 100) > firstPair
//                    && isPrime(i % 100)
//                    && (i % 100) <= Integer.parseInt(String.valueOf(secondPair + secondPairValueDifference)) && (i % 100) > secondPair) {
//                System.out.printf("%d ", i);
//            }
//        }


    }


}

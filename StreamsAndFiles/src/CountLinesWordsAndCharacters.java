public class CountLinesWordsAndCharacters {
    public static void main(String[] args) {
        String name = "./Files/Input.txt";

        

    }

    public static int calculateFallenOrcs(int initialCount, int increase, int hours) {
        if (initialCount < 0) {
            throw new IllegalArgumentException("Initial count of orcs cannot be negative.");
        }
        if (hours < 0) {
            throw new IllegalArgumentException("Number of hours cannot be negative.");
        }
        int orcCount = 0;
        for (int i = 0; i < hours; i++, initialCount += increase) {
            orcCount += initialCount;
        }

        return orcCount;
    }

}

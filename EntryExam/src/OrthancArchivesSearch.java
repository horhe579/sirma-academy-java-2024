import java.util.Scanner;

public class OrthancArchivesSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String[] records = sc.nextLine().split("[, ]+");
            String term = sc.nextLine();
            sc.close();
            findFirstAndLastOccurrence(records, term);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(STR."An unexpected error occurred: \{e.getMessage()}");
        } finally {
            sc.close();
        }
    }

    public static void findFirstAndLastOccurrence(String[] records, String searchTerm) {
        if (records.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }
        if (searchTerm.length() == 0) {
            throw new IllegalArgumentException("Cannot search for an empty string.");
        }

        for (int i = 0; i < records.length; i++) {
            if (records[i].equals(searchTerm)) {
                System.out.println(STR."First Occurrence: \{i}");
                for (int j = records.length - 1; j >= i; j--) {
                    if (records[j].equals(searchTerm)) {
                        System.out.println(STR."Last Occurrence: \{j}");
                        return;
                    }
                }
            }
        }
        System.out.println("Record not found");

    }
}

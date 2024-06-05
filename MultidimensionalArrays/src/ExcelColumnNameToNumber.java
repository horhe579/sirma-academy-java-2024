import java.util.Arrays;

public class ExcelColumnNameToNumber {
    public static void main(String[] args) {
        System.out.println(columnNameToInt("AB"));
        System.out.println(columnNameToInt("A"));
        System.out.println(columnNameToInt("C"));
        System.out.println(columnNameToInt("CZ"));
        System.out.println(columnNameToInt("MM"));
        System.out.println(columnNameToInt("AAA"));
        System.out.println(columnNameToInt("AAAA"));
    }

    public static int columnNameToInt(String columnName)
    {
        Character [] columnCharacters = columnName.toLowerCase().chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        if(columnCharacters.length > 3)
        {
            throw new RuntimeException("3 characters at max.");
        }
        switch (columnCharacters.length)
        {
            case 1:
                return (columnCharacters[0] - 'a' + 1);
            case 2:
                return 26*(columnCharacters[0] - 'a' + 1) + (columnCharacters[1] - 'a' + 1);
            case 3:
                return 676*(columnCharacters[0] - 'a' + 1) + 26*(columnCharacters[1] - 'a' + 1) + (columnCharacters[2] - 'a' + 1);
        }

        return 0;
    }
}

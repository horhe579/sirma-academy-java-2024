import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentCount = Integer.parseInt(sc.nextLine());

        TreeMap<String, ArrayList<Double>> studentRecord = new TreeMap<>();

        addStudents(studentRecord, studentCount);
        printStudents(studentRecord);

    }

    public static String [] readStudentInfo()
    {
        Scanner sc = new Scanner(System.in);
        String [] studentInfo = sc.nextLine().split("[, ]+");
        return studentInfo;
    }

    public static void addStudents(TreeMap<String, ArrayList<Double>> studentRecord, int count)
    {
        for (int i = 0; i < count; i++) {
            String [] studentInfo = readStudentInfo();
            studentRecord.putIfAbsent(studentInfo[0], new ArrayList<Double>());
            if(studentRecord.containsKey(studentInfo[0]))
            {
                studentRecord.get(studentInfo[0]).add(Double.parseDouble(studentInfo[1]));
            }
        }
    }

    public static void printStudents(TreeMap<String, ArrayList<Double>> studentRecord)
    {
        for(var set : studentRecord.entrySet())
        {
            System.out.println(STR.
                    "\{set.getKey()} -> \{set.getValue()} (\{String.format("%.2f", set.getValue().stream().mapToDouble(Double::doubleValue).sum()/set.getValue().size())})");
        }
    }
}

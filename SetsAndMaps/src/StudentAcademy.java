import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, ArrayList<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; ) {
            boolean isValid = false;
            String studentName = sc.nextLine();
            Double grade = null;

            while (!isValid) {
                try {
                    grade = Double.parseDouble(sc.nextLine());
                    if (grade >= 2.0 && grade <= 6.0) {
                        isValid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (isValid) {
                addStudent(students, studentName, grade);
                i++;
            }
        }
        printStudents(students);
    }

    private static void addStudent(LinkedHashMap<String, ArrayList<Double>> students, String name, Double grade) {
        students.putIfAbsent(name, new ArrayList<>());
        students.get(name).add(grade);
    }

    private static void printStudents(LinkedHashMap<String, ArrayList<Double>> students) {
        for (var student : students.entrySet()) {
            Double averageGrade = student.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            if (averageGrade >= 4.50) {
                System.out.println(STR."\{student.getKey()} -> \{String.format("%.2f", averageGrade)}");
            }
        }
    }
}

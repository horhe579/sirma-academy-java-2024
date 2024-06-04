import Classes.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while(true)
        {
            String [] input = sc.nextLine().split("[, ]+");
            if(input.length == 1 && input[0].equals("end"))
            {
                break;
            }
            Student student = new Student(input[0], input[1], Integer.parseInt(input[2]), input[3]);
            students.add(student);
        }

        String homeTown = sc.nextLine();

        students.stream().filter(e -> e.getHometown().equals(homeTown)).
                forEach(student ->
                        System.out.println(STR."\{student.getFirstName()} \{student.getLastName()} is \{student.getAge()} \{(student.getAge() == 1) ? "year" : "years"} old"));

    }
}

import Classes.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <String> command = new ArrayList<>();
        PriorityQueue<Task> tasks = new PriorityQueue<>(
                (t1, t2) -> {
                    if(t1.getPriority() == t2.getPriority())
                    {
                        return (t1.getName().compareTo(t2.getName()) == 0)
                                ? 0
                                : t1.getName().compareTo(t2.getName()) > 0
                                ? 1 : -1;
                    }
                    else if(t1.getPriority() > t2.getPriority())
                    {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
        );

        while (!command.equals("end"))
        {
            command = new ArrayList(Arrays.asList(sc.nextLine().split("[ ]+")));
            if(command.get(0).equals("Add"))
            {
                tasks.offer(new Task(command.get(1), Integer.parseInt(command.get(2))));
            } else if (command.get(0).equals("getNextTask")) {
                Task task = tasks.poll();
                System.out.println(tasks.peek().toString());
                tasks.offer(task);
            }
            else {
                System.out.println("invalid");
            }
        }


    }
}

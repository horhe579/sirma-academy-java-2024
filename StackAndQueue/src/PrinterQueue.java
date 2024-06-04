import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = "";
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while(true)
        {
            command = sc.nextLine().trim();
            if(command.toLowerCase().equals("cancel"))
            {
                System.out.println((printerQueue.isEmpty())
                        ? "Standby"
                        : STR."Canceled \{printerQueue.poll()}");
            } else if(!command.equals("print")){
                printerQueue.offer(command);
            }
            else{
                System.out.println(printerQueue);
                return;
            }
        }
    }
}

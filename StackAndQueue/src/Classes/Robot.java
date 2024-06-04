package Classes;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.Arrays;

public class Robot {

    private String name;
    private int processingTime;
    private ArrayList<Integer> availableAt = new ArrayList<>(Arrays.asList(0, 0, 0));

    public Robot(String name, int processingTime) {
        this.name = name;
        this.processingTime = processingTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getAvailableAt() {
        return availableAt;
    }

    public void processProduct(Product product, int[] currentTime) {
        System.out.println(STR."\{this.name} - \{product.getName()} [\{currentTime[0]}:\{currentTime[1]}:\{currentTime[2]}]");
        for (int i = 0; i < 3; i++) {
            if(i == 2)
            {
                availableAt.set(i, currentTime[i] + processingTime);
                continue;
            }
            availableAt.set(i, currentTime[i]);
        }
        correctTimeFormat();
    }
    
    public static int[] correctTimeFormat(int [] time)
    {
        if (time[2] >= 60) {
            int overflow = time[2] / 60;
            time[2] = time[2]%60;
            time[1] = time[1] + overflow;
        }

        if (time[1] >= 60) {
            int overflow = time[1] / 60;
            time[1] = time[1]%60;
            time[0] = time[0] + overflow;
        }

        if (time[0] >= 24) {
            time[0] = time[0]%24;
        }
        return time;
    }

    private void correctTimeFormat() {
        if (availableAt.get(2) >= 60) {
            int overflow = availableAt.get(2) / 60;
            availableAt.set(2, availableAt.get(2) % 60);
            availableAt.set(1, availableAt.get(1) + overflow);
        }

        if (availableAt.get(1) >= 60) {
            int overflow = availableAt.get(1) / 60;
            availableAt.set(1, availableAt.get(1) % 60);
            availableAt.set(0, availableAt.get(0) + overflow);
        }

        if (availableAt.get(0) >= 24) {
            availableAt.set(0, availableAt.get(0) % 24);
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", processingTime=" + processingTime +
                ", availableAt=" + availableAt +
                '}';
    }
}

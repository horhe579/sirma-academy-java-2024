package com.sirmaacademy.packages.solid.correct.dip.lightswitch;

import java.util.Scanner;

public class LightSwitchExample {

    public static void main(String[] args) {
        LightSwitch switch1 = new LightSwitch(new Bulb());

        try(Scanner sc = new Scanner(System.in))
        {
            String command = "";
            while(!command.equals("stop"))
            {
                command = sc.nextLine();
                switch(command)
                {
                    case "on":
                        switch1.operate(true);
                        break;
                    case "off":
                        switch1.operate(false);
                        break;
                    default:
                        System.out.println("Unknown command.");
                        break;
                }
            }
        }
    }
}

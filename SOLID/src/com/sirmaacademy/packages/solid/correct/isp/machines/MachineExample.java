package com.sirmaacademy.packages.solid.correct.isp.machines;

public class MachineExample {

    public static void main(String[] args) {
        PrintableMachine machine1 = new PrintableMachine();
        ScannableMachine machine2 = new ScannableMachine();
        FaxableMachine machine3 = new FaxableMachine();
        GreatMachine machine4 = new GreatMachine();
        machine1.print(1);
        machine1.print("String");
        machine1.print(2.1);
        machine1.print(new StringBuilder("Peter"));

        machine2.scan(1);
        machine2.scan("String");
        machine2.scan(2.1);
        machine2.scan(new StringBuilder("Peter"));

        machine3.fax();

        machine4.print(24);
        machine4.scan(42);
        machine4.fax();
    }
}

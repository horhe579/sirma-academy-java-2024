package MethodsExercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.StringTemplate.STR;

public class Methods {

    public static void signOfInteger(int number) {
        String message = (number > 0) ? "positive" : (number < 0) ? "negative" : "zero";
        System.out.println(STR."The number \{number} is \{message}.");
    }

    public static void grades(double grade) {
        if (grade > 6.0 || grade < 2.0) {
            System.out.println("Invalid argument.");
            return;
        }

        String result = (grade >= 2.00 && grade <= 2.99) ? "Fail"
                : (grade >= 3.0 && grade <= 3.49) ? "Poor"
                : (grade >= 3.50 && grade <= 4.49) ? "Good"
                : (grade >= 4.50 && grade <= 5.49) ? "Very good"
                : "Excellent";

        System.out.println(result);
    }

    public static void printingTriangle(int number) {
        for (int i = 1; i < number; i++) {
            printTriangleRow(i);
        }
        printTriangleRow(number);
        for (int i = number - 1; i > 0; i--) {
            printTriangleRow(i);
        }
    }

    private static void printTriangleRow(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(STR."\{i} ");
        }
        System.out.println();
    }

    public static void basicCalculation(String operation, double a, double b) {
        switch (operation.toLowerCase()) {
            case "add":
                System.out.println(add(a, b));
                return;
            case "subtract":
                System.out.println(subtract(a, b));
                return;
            case "divide":
                System.out.println(divide(a, b));
                return;
            case "multiply":
                System.out.println(multiply(a, b));
                return;
            default:
                throw new ArithmeticException("Invalid operator");
        }
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by 0 not allowed.");
            throw new ArithmeticException("Division by zero");
        }
        return ((double) a / (double) b);
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    public static void calculateOrderPrice(String product, int quantity) {
        Map<String, Double> prices = new HashMap<String, Double>() {{
            put("coffee", 1.5);
            put("water", 1.0);
            put("coke", 1.4);
            put("snacks", 2.0);
        }};

        String productKey = product.toLowerCase();

        if (!prices.containsKey(productKey)) {
            throw new IllegalArgumentException("Invalid product.");
        }

        System.out.println(STR."\{prices.get(productKey) * quantity}");
    }

    public static double calculateRectangleArea(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        return a * b;
    }

    public static String repeatString(String text, int n) {
        StringBuilder finalText = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalText.append(text);
        }
        return finalText.toString();
    }

    public static double mathPower(double number, double power) {
        double result = 1;
        if (power == 0.0) {
            return power;
        } else if (power > 0.0) {
            result = Math.pow(number, power);
        } else if (power < 0.0) {
            result = 1.0 / mathPower(number, -power);
        }
        return result;
    }
//    make it work with reflection why not
//    public static Class getMax(Class var)
//    {
//        var.getClass()
//    }

    public static void getMax(String type, String a, String b) {
        switch (type.toLowerCase()) {
            case "string":
                System.out.println(getMaxString(a, b));
                return;
            case "int":
                try {
                    int aToInt = Integer.parseInt(a);
                    int bToInt = Integer.parseInt(b);
                    System.out.println(getMaxInt(Integer.parseInt(a), Integer.parseInt(b)));
                } catch (Exception e) {
                    throw new IllegalArgumentException("Invalid argument.");
                }
                return;
            case "char":
                try {
                    if (a.length() > 1 || b.length() > 1) {
                        throw new Exception();
                    }
                    char aToChar = a.charAt(0);
                    char bToChar = b.charAt(0);
                    System.out.println(getMaxChar(aToChar, bToChar));
                } catch (Exception e) {
                    throw new IllegalArgumentException("Invalid argument.");
                }
        }
    }

    private static String getMaxString(String a, String b) {
        return (a.compareTo(b) >= 0) ? a : b;
    }

    private static char getMaxChar(char a, char b) {
        return (a > b) ? a : b;
    }

    private static int getMaxInt(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int multiplyEvensByOdds(int number) {
        int evenSum = 0;
        int oddSum = 0;
        String numberToString = String.valueOf(number);

        for (int i = 0; i < numberToString.length(); i++) {
            int digit = Character.getNumericValue(numberToString.charAt(i));
            if (digit % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }

        return evenSum * oddSum;
    }

    public static void mathOperations(double a, double b, char operator) {
        switch (operator) {
            case '+':
                System.out.println(add(a, b));
                return;
            case '-':
                System.out.println(subtract(a, b));
                return;
            case '/':
                System.out.println(divide(a, b));
                return;
            case '*':
                System.out.println(multiply(a, b));
                return;
            default:
                throw new ArithmeticException("Invalid operator");
        }
    }

    public static void validatePassword(String password) {
        int flag = 0;
        int digitCount = 0;
        if (!(password.length() >= 6 && password.length() <= 10)) {
            System.out.println("Password must be between 6 and 10 characters.");
            flag++;
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(!(Character.isDigit(c) || Character.isLetter(c)))
            {
                System.out.println("Password must contain only letters and digits");
                flag++;
            }
            digitCount += (Character.isDigit(c)) ? 1 : 0;
        }


        if(digitCount < 2)
        {
            System.out.println("Password must have at least 2 digits.");
            flag++;
        }

        if (flag == 0) {
            System.out.println("Password is valid.");
        }
    }

}

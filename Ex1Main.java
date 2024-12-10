package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        System.out.println("Welcome to the number calculator!");
        System.out.println("You will be asked to enter two numbers (in string format) and a base for the output.");
        System.out.println("If you want to quit the program, simply type 'quit' when prompted.");
        System.out.println("Let's begin!");


        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter the first number (or 'quit' to exit):");
            num1 = sc.next();

            if (!num1.equals("quit")) {
                boolean isNum1 = Ex1.isNumber(num1);
                int num1Converted = isNum1 ? Ex1.number2Int(num1) : -1;
                if (num1Converted == -1) {
                    System.out.println("Invalid input! (" + num1 + " is not in a format)");
                    continue;
                }
                System.out.println("num1= " + num1 + " is number: " + isNum1 + " , value: " + num1Converted);

                System.out.println("Enter the second number (or 'quit' to exit):");
                num2 = sc.next();
                if (!num2.equals("quit")) {
                    boolean isNum2 = Ex1.isNumber(num2);
                    int num2Converted = isNum2 ? Ex1.number2Int(num2) : -1;
                    if (num2Converted == -1) {
                        System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        continue;
                    }
                    System.out.println("num2= " + num2 + " is number: " + isNum2 + " , value: " + num2Converted);

                    System.out.println("Enter the base for output: (choose a base between 2 and 16):");
                    int base = sc.nextInt();
                    if (base < 2 || base > 16) {
                        System.out.println("Invalid input! (" + base + " is not in the range [2,16])");
                        continue;
                    }

                    // המרת המספר לבסיס בין 2 ל-16
                    String baseChar = (base <= 10) ? String.valueOf(base) : String.valueOf((char) ('A' + (base - 10)));
                    String sumResult = Ex1.int2Number(num1Converted + num2Converted, base) + (base == 10 ? "" : "b" + baseChar);
                    String productResult = Ex1.int2Number(num1Converted * num2Converted, base) + (base == 10 ? "" : "b" + baseChar);

                    System.out.println("Result");
                    System.out.println(num1 + " + " + num2 + " = " + sumResult);
                    System.out.println(num1 + " * " + num2 + " = " + productResult);

                    String num1Formatted = num1.contains("b") ? num1 : num1;
                    String num2Formatted = num2.contains("b") ? num2 : num2;
                    String[] numberArray = {num1Formatted, num2Formatted, sumResult, productResult};

                    // מציאת המקסימום לפי הערכים המספריים
                    int[] values = {num1Converted, num2Converted, num1Converted + num2Converted, num1Converted * num2Converted};
                    int maxValue = values[0];
                    String maxStr = numberArray[0];
                    for (int i = 1; i < values.length; i++) {
                        if (values[i] > maxValue) {
                            maxValue = values[i];
                            maxStr = numberArray[i];
                        }
                    }
                    System.out.println("Max number over [" + num1Formatted + "," + num2Formatted + "," + sumResult + "," + productResult + "] is: " + maxStr);
                }
            }
        }
        System.out.println("Thank you for using the program! Quitting now...");
    }
}

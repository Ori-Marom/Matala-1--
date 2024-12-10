package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public  class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if (num == null || num.isEmpty() || !num.contains("b")) {
            try {
                return Integer.parseInt(num);
            }catch (NumberFormatException e) {
                return ans;
            }

        }

        String[] parts = num.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return ans;
        }

        String numberparts = parts[0];
        String basepart = parts[1];
        int base;

        try {
            base = Integer.parseInt(basepart);
        } catch (NumberFormatException e) {
            switch (basepart) {
                case "A": base = 10; break;
                case "B": base = 11; break;
                case "C": base = 12; break;
                case "D": base = 13; break;
                case "E": base = 14; break;
                case "F": base = 15; break;
                case "G": base = 16; break;
                default:
                    return ans;
            }
        }
//        System.out.println("numberparts: " + numberparts + ", basepart: " + basepart);
//        System.out.println("Base calculated: " + base);


        if (base < 2 || base > 16) {
            return ans;
        }

        try {
            ans = Integer.parseInt(numberparts, base);
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse number: " + numberparts + " with base: " + base);
            return ans;
        }
//        System.out.println("Parsed number: " + ans);

        return ans;
    }
    /**
     * This static function checks if the given String (a) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;

        if (a == null || a.length() == 0) {
            return false;
        }

        if (!a.contains("b")) {
            return a.matches("[0-9]+");
        }

        if (a.indexOf("b") == 0 || a.indexOf("b") == a.length() - 1) {
            return false;
        }

        String[] parts = a.split("b");
        if (parts.length != 2) {
            return false;
        }

        String numberparts = parts[0];
        String basepart = parts[1];

        if (numberparts.isEmpty() || basepart.isEmpty()) {
            return false;
        }

        int base;
        try {
            base = Integer.parseInt(basepart);
        } catch (NumberFormatException e) {
            switch (basepart) {
                case "A": base = 10; break;
                case "B": base = 11; break;
                case "C": base = 12; break;
                case "D": base = 13; break;
                case "E": base = 14; break;
                case "F": base = 15; break;
                case "G": base = 16; break;
                default: return false;
            }
        }

        if (base < 2 || base > 16) {
            return false;
        }

        for (int i = 0; i < numberparts.length(); i++) {
            char c = numberparts.charAt(i);
            if (!(Character.isDigit(c) || (c >= 'A' && c <= 'G'))) {
                return false;
            }

            int value;
            if (Character.isDigit(c)) {
                value = c - '0';
            } else {
                value = c - 'A' + 10;
            }

            if (value >= base) {
                return false;
            }
        }

        return ans;
    }


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16) {
            return ans;
        }
        if (num == 0) {
            return "0";
        }


        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int reminder = num % base;
//            System.out.println("Reminder: " + reminder);
            char digit = (char) (reminder < 10 ? '0' + reminder : 'A' + reminder - 10);
            result.insert(0, digit);
            num /= base;

        }

//        System.out.println("Result: " + result.toString());


        return result.toString();
    }


    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if (number2Int(n1) == number2Int(n2)){
            return ans;
        }
        return ans;

    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].length()) {
                max = arr[i].length();
                ans = i;
            }

        }


        return ans;
    }
}
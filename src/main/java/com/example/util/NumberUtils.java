package com.example.util;

public class NumberUtils {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isPerfect(int number) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += i + number / i;
            }
        }
        return sum == number && number != 1;
    }

    public static String[] getProperties(int number) {
        boolean isArmstrong = isArmstrong(number);
        boolean isOdd = number % 2 != 0;
        if (isArmstrong && isOdd) return new String[]{"armstrong", "odd"};
        if (isArmstrong) return new String[]{"armstrong", "even"};
        if (isOdd) return new String[]{"odd"};
        return new String[]{"even"};
    }

    // Armstrong number is a number that is equal to the sum of its own digits raised
    // to the power of the number of digits
    // Example: 153 = 1^3 + 5^3 + 3^3
    public static boolean isArmstrong(int number) {
        int sum = 0, temp = number, digits = String.valueOf(number).length();
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == number;
    }

    public static int getDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
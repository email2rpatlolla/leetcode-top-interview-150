package com.leetcode.top.interview.easy;

import java.util.*;

public class RomanToInteger {

    public static void main(String[] args) {
        approach1("III");
        approach1("LVIII");
        approach1("MCMXCIV");

        betterApproach("III");
        betterApproach("LVIII");
        betterApproach("MCMXCIV");

        betterApproach2("III");
        betterApproach2("LVIII");
        betterApproach2("MCMXCIV");
    }

    private static int betterApproach(String s) {
        int returnValue = 0;
        int prevValue = 0;
        int currentValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            {
                switch (s.charAt(i)) {
                    case 'M' -> currentValue = 1000;
                    case 'D' -> currentValue = 500;
                    case 'C' -> currentValue = 100;
                    case 'L' -> currentValue = 50;
                    case 'X' -> currentValue = 10;
                    case 'V' -> currentValue = 5;
                    case 'I' -> currentValue = 1;
                }

                if (currentValue < prevValue) {
                    returnValue = returnValue - currentValue;
                } else
                    returnValue = returnValue + currentValue;
                prevValue = currentValue;
            }
        }
        System.out.println(">>>>>>>>>>>>"+returnValue);
        return returnValue;
    }

    private static int betterApproach2(String s) {
        int returnValue = 0;
        int prevValue = 0;
        int currentValue = 0;

        for (int i = 0; i < s.length(); i++) {
            {
                switch (s.charAt(i)) {
                    case 'M' -> currentValue = 1000;
                    case 'D' -> currentValue = 500;
                    case 'C' -> currentValue = 100;
                    case 'L' -> currentValue = 50;
                    case 'X' -> currentValue = 10;
                    case 'V' -> currentValue = 5;
                    case 'I' -> currentValue = 1;
                }
                returnValue += currentValue;
                if (prevValue < currentValue) returnValue -= 2 * prevValue;

                prevValue = currentValue;
            }
        }
        System.out.println(">>>>>>>>>>>>"+returnValue);
        return returnValue;
    }

    private static int approach1(String s) {
        Map<String, Integer> values = config();

        Queue<String> list = new LinkedList<>(Arrays.asList(s.split("")));

        int number = 0;

        while(!list.isEmpty()) {
            var curSymbol = list.poll();
            var nextSymbol = list.peek();

            var currVal = values.get(curSymbol);
            var nextVal = values.get(nextSymbol);

            if (nextVal == null || currVal >= nextVal) {
                number = number + currVal;
            } else {
                number = number + (nextVal - currVal);
                list.poll();
            }
        }
        return number;
    }

    public static Map<String, Integer> config() {
        Map<String, Integer> values = new HashMap<>(7);
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        return values;
    }

}

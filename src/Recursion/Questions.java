package Recursion;

import java.util.ArrayList;
import java.util.List;

class Questions {
    // Letter combinations of a phone number
    public static void pad(String p, String digits) {
        if (digits.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = digits.charAt(0) - '0'; // this will convert '2' to 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p+ch, digits.substring(1));
        }
    }
    public static List<String> letterCombinations(String p, String digits) {
        if (digits.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = digits.charAt(0) - '0'; // this will convert '2' to 2

        List<String> list = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            list.addAll(letterCombinations(p+ch, digits.substring(1)));
        }
        return list;
    }

    // How many ways are there to form a number 'n' on a die
    public static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p+i, target-i);
        }
    }
    public static List<String> diceRet(String p, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p+i, target-i));
        }
        return list;
    }

    public static void main(String[] args) {
        // pad("", "12");
        // System.out.println(letterCombinations("", "12"));
        dice("", 4);
        System.out.println(diceRet("", 4));
    }
}
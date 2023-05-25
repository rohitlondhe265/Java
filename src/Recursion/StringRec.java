package Recursion;

import java.util.ArrayList;

public class StringRec {

    // skipp a character
    public static String skipChar(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
           return skipChar(up.substring(1));
        }
        return ch + skipChar(up.substring(1));
    }

    // Subset Of a String
    public static void subset(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subset(p+ch, up.substring(1));
        subset(p, up.substring(1));
    }
    public static ArrayList<String> subsetList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsetList(p+ch, up.substring(1));
        ArrayList<String> right = subsetList(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    // Permutations
    public static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i);
            permutation(f+ch+l, up.substring(1));
        }
    }
    public static ArrayList<String> permutationList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> curr = new ArrayList<>();
            curr.add(p);
            return curr;
        }
        // local to this call only
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i);
            ans.addAll(permutationList(f+ch+l, up.substring(1)));
        }
        return ans;
    }
    // Count no of Permutations
    public static int permutationCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);

        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i);
            count += permutationCount(f+ch+l, up.substring(1));
        }
        return count;
    }

    public static void main(String[] args) {
        // permutation("", "abc");
        // System.out.println(permutationList("", "abc"));
        // System.out.println(permutationCount("", "abc"));
        // subset("", "abc");
        // System.out.println(subsetList("", "abc"));
        System.out.println(skipChar("abc"));
    }
}

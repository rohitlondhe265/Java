package Recursion;

import java.util.HashSet;

public class Nine_Recursion_Questions {

    // 1. Tower of Hanoi
    // only one disk transfer in one step and smaller disks are always kept on top
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("transfer disk "+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);
    }

    // print a string in reverse
    public static void reverse(String str, int index){
        if(index == 0){
            System.out.print(str.charAt(index));
            return;
        }
        char curr = str.charAt(index);
        System.out.print(curr);
        reverse(str, index-1);
    }

    // find the index of first and last occurance of a character in the string 
    static int first = -1;
    static int last = -1;
    public static void findOccurance(String str, int index, char element){
        if(index == str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currElement = str.charAt(index);
        if(currElement == element){
            if(first == -1){
                first = index;
            } else {
                last = index;
            }
        }
        findOccurance(str, index+1, element);
    }

    // check if array is sorted or not {strictly}
    public static boolean isSorted(int arr[], int index){
        if(index == arr.length-1){
            return true;
        }
        if(arr[index] < arr[index+1]){
            return isSorted(arr, index+1);
        } else{
            return false;
        }
    }

    // move all "x" in the end of the string
    public static void moveX(String str, int index, int count, String newStr){
        if(index == str.length()){
            for(int i=0; i<count; i++){
                newStr += 'x';
            }
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(index);
        if(currChar == 'x'){
            count++;
            moveX(str, index+1, count, newStr);
        } else {
            moveX(str, index+1, count, newStr+currChar);
        }
    }

    // remove duplicates in a string
    public static boolean arr[] = new boolean[26];
    public static void removeDuplicates(String str, int index, String newStr){
        if(index == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(index);
        if(arr[currChar - 'a'] == true){
            removeDuplicates(str, index+1, newStr);
        } else {
            newStr += currChar;
            arr[currChar - 'a'] = true;
            removeDuplicates(str, index+1, newStr);
        }
    }

    // print all the subsequences of a string [O(2^n)]
    public static void printSubsequences(String str, int index, String newStr){
        if(index == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(index);
        // to be
        printSubsequences(str, index+1, newStr+currChar);
        // not to be
        printSubsequences(str, index+1, newStr);
    }

    // print all the unique subsequences of a string
    public static void subsequences2(String str, int index, String newStr, HashSet<String> set){
        if(str.length() == index){
            if (set.contains(newStr)) {
                return;
            } else{
                set.add(newStr);
                System.out.println(newStr);
                return;
            }
        }

        char currChar = str.charAt(index);

        subsequences2(str, index+1, newStr+currChar, set);

        subsequences2(str, index+1, newStr, set);
    }

    // Print keypad combinatios
    public static String[] keyPad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void keyPadCombinations(String str, int index, String combination){
        if(index == str.length()){
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(index);
        String mapping = keyPad[currChar-'0'];
        for(int i=0; i<mapping.length(); i++){
            keyPadCombinations(str, index+1, combination+mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        // towerOfHanoi(3, "S", "H", "D");

        // String str = "null";
        // reverse(str, str.length()-1);

        // findOccurance("roakdslfkafks", 0, 'a');

        // int arr[] = {1, 5, 15, 16};
        // boolean result = isSorted(arr, 0);
        // System.out.println(result);

        // moveX("xnuxxll", 0, 0, "");

        // removeDuplicates("nlllssddull", 0, "");

        // printSubsequences("abc", 0, "");

        // HashSet<String> set = new HashSet<>();
        // subsequences2("aaa", 0, "", set);

        // keyPadCombinations("234", 0, "");

    }
}
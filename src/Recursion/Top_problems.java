package Recursion;

import java.util.ArrayList;

public class Top_problems {

    // print all possible permutations of string characters
    public static void permutations(String str, String permutation){
        if(str.length()==0){
            System.out.println(permutation);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
            // "abc" -> "bc"
            String newStr = str.substring(0, i) + str.substring(i+1);
            permutations(newStr, permutation+currChar);
        }
    }

    // count total paths in maze to move from (0,0) to (n,m). we can only move downords and right
    public static int maze(int i, int j, int m, int n){
        if(i == m || j == n){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }
        // move downwords
        int downpaths = maze(i, j+1, m, n);
        // move rignt
        int rigntpaths = maze(i+1, j, m, n);
        return downpaths + rigntpaths;
    }

    // place tiles of size 1*m in a floor of size n*m
    public static int placeTiles(int n, int m){
        if(n == m){
            return 2;
        }
        if(n < m){
            return 1;
        }
        // place vertically
        int verticlePlacements = placeTiles(n-m, m);
        // place horizontly
        int horizontalPlacements = placeTiles(n-1, m);
        return verticlePlacements + horizontalPlacements;
    }

    // number of ways you can invite n people to your party single or in pairs
    public static int callGuests(int n){
        if(n <= 1){
            return 1;
        }
        // invite in single
        int way1 = callGuests(n-1);
        // invite in double
        int way2 = (n-1) * callGuests(n-2);
        return way1 + way2;
    }

    // print all the subsets of set of first n natural numbers [combinations]
    public static void printSubset(ArrayList<Integer> subset){
        for(int i=0; i<subset.size(); i++){
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void findSubsets(ArrayList<Integer> subset, int n){
        if(n == 0){
            printSubset(subset);
            return;
        }
        // add number
        subset.add(n);
        findSubsets(subset, n-1);
        // don't add number
        subset.remove(subset.size()-1);
        findSubsets(subset, n-1);
    }

    public static void main(String[] args) {
        // permutations("abc", "");
        // System.out.println(maze(0, 0, 3, 3));
        // System.out.println(placeTiles(4, 2));
        // System.out.println(callGuests(4));
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(subset, 3);
    }   
}

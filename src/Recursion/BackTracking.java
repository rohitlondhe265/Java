package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTracking {
    // Maze Problems : 
    // No of paths in 2D array to reach end
    public static int paths(int r, int c) {
        if (r==1 || c==1) {
            return 1;
        }
        int left = paths(r-1, c);
        int right = paths(r, c-1);
        return left + right;
    }
    public static void mazePaths(int r, int c, String p) {
        if (r==1 && c==1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            mazePaths(r-1, c, p+"D");
        }
        if(c > 1) {
        mazePaths(r, c-1, p+"R");
        }
    }
    public static ArrayList<String> mazePathsAL(int r, int c, String p) {
        if (r==1 && c==1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        // Local list
        ArrayList<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(mazePathsAL(r-1, c, p+"D"));
        }
        if(c > 1) {
            list.addAll(mazePathsAL(r, c-1, p+"R"));
        }
        return list;
    }

    // Maze with obstacles
    public static void mazeWithObstacle(boolean[][] maze, int r, int c, String p) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1) {
            mazeWithObstacle(maze, r+1, c, p+"D");
        }
        if (c < maze[0].length - 1) {
            mazeWithObstacle(maze, r, c+1, p+"R");
        }
    }

    // Back Tracking (D: down, R: right, U: up, L: left)
    public static void allPaths(boolean[][] maze, int r, int c, String p) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPaths(maze, r+1, c, p+"D");
        }
        if (c < maze[0].length - 1) {
            allPaths(maze, r, c+1, p+"R");
        }
        if (r > 0) {
            allPaths(maze, r-1, c, p+"U");
        }
        if (c > 0) {
            allPaths(maze, r, c-1, p+"L");
        }

        // this is the line where the fuction will be over
        // so before the fuction gets removed, also remove the chages made in original maze due to the fuction
        maze[r][c] = true;
    }

    public static void allPathsPrint(boolean[][] maze, int r, int c, String p, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            allPathsPrint(maze, r+1, c, p+"D", path, step+1);
        }
        if (c < maze[0].length - 1) {
            allPathsPrint(maze, r, c+1, p+"R", path, step+1);
        }
        if (r > 0) {
            allPathsPrint(maze, r-1, c, p+"U", path, step+1);
        }
        if (c > 0) {
            allPathsPrint(maze, r, c-1, p+"L", path, step+1);
        }

        // this is the line where the fuction will be over
        // so before the fuction gets removed, also remove the chages made in original maze due to the fuction
        maze[r][c] = true;
        path[r][c] = 0;
    }

    // N-Queens
    public static int nQueens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueens(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check for Horizontal direction
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // for left Diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 0; i <= maxLeft; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }
        // for right Diagonal
        int maxRight = Math.min(row, board.length-1-col);
        for (int i = 0; i <= maxRight; i++) {
            if (board[row-i][col+i]) {
                return false;
            }
        }

        return true;
    }
    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean col : row) {
                if (col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    // N-Knights
    public static void nKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            displayKnight(board);
            System.out.println();
            return;
        }
        if (row == board.length-1 && col == board.length) {
            return;
        }
        if (col == board.length) {
            nKnights(board, row+1, 0, knights);
            return;
        }
        if (isSafeKnight(board, row, col)) {
            board[row][col] = true;
            nKnights(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        // if it's not safe to put just move ahead
        nKnights(board, row, col+1, knights);
    }
    private static boolean isSafeKnight(boolean[][] board, int row, int col) {
        // top left
        if (isValid(board, row-2, col-1)) {
            if (board[row-2][col-1]) {
                return false;
            }
        }
        // top right
        if (isValid(board, row-2, col+1)) {
            if (board[row-2][col+1]) {
                return false;
            }
        }
        // top left
        if (isValid(board, row-1, col+2)) {
            if (board[row-1][col+2]) {
                return false;
            }
        }
        // top right
        if (isValid(board, row-1, col-2)) {
            if (board[row-1][col-2]) {
                return false;
            }
        }
        return true;
    }
    // to check whether the row and col provided are out of bound or not
    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }
    private static void displayKnight(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean col : row) {
                if (col) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // System.out.println(paths(3, 3));
        // mazePaths(3, 3, "");
        // System.out.println(mazePathsAL(3, 3, ""));

        // boolean[][] maze = {
        //     {true, true, true},
        //     {true, true, true},
        //     {true, true, true}
        // };
        // mazeWithObstacle(maze, 0, 0, "");
        // int[][] path = new int[maze.length][maze[0].length];

        // // allPaths(maze, 0, 0, "");
        // allPathsPrint(maze, 0, 0, "", path, 1);
        boolean[][] board = new boolean[4][4];
        // System.out.println(nQueens(board, 0));
        nKnights(board, 0, 0, 8);
    }
}

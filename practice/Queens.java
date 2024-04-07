package practice;

import java.util.Arrays;

public class Queens {

    public static void printBoard(int[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col) {

        for(int i = 0; i < col; i++){
            if(board[row][i] == 1)
                return false;
        }

        for(int i = row, j = col; i > -1 && j > -1; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }

        for(int i = row, j = col; i < board.length && j > -1; i++, j--) {
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }

    public static boolean NQueens(int[][] board, int col, int[] count) {
        
        if (col == board.length) {
            printBoard(board);
            count[0] ++;
            return true;
        }

        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                res = NQueens(board, col + 1, count) || res;
    
                board[i][col] = 0;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int boardSize = 8;
        int[][] board = new int[boardSize][boardSize];
        int[] count = new int[1];
        count[0] = 0;
        NQueens(board, 0, count);
        System.out.println(count[0]);
    }
}

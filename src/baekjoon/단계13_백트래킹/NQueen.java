package baekjoon.단계13_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[N][N];

        NQueen(board, 0);
        System.out.println(count);
    }

    private static void NQueen(boolean[][] board, int row) {
        if(row == N){
            count ++;
            return;
        }
        for(int j = 0; j < N; j++){
            if(isSafe(board,row, j)){
                board[row][j] = true;
                NQueen(board, row+1);
                board[row][j] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // 같은 열 검사
        for(int i = 0 ; i<row; i++){
            if(board[i][col]) return false;
        }
        // 대각선 검사.
        int leftDiagonal = col - 1;
        int rightDiagonal = col + 1;
        for(int i=row-1; i>=0; i--){
            if(leftDiagonal >= 0 && board[i][leftDiagonal--]) return false;
            if(rightDiagonal < board.length && board[i][rightDiagonal++]) return false;
        }
        return true;
    }
}

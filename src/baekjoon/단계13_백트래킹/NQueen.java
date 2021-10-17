package baekjoon.단계13_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[N][N];

        NQueen(board, 0);
    }

    private static void NQueen(boolean[][] board, int row) {
        if(row == N-1){
            
        }

        for(int j = 0; j < N; j++){
            if(isSafe(row, j)){
                boolean[][] copyBoard = Arrays.copyOf(board, board.length);
                copyBoard[row][j] = true;
                NQueen(copyBoard, row+1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
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

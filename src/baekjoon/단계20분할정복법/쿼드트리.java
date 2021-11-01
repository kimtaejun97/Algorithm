package baekjoon.단계20분할정복법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
    static char[][] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        // 입력 데이터
        for(int i=0; i<n; i++){
            board [i] = br.readLine().toCharArray();
        }
        split(0, 0, n);
        System.out.print(sb.toString());
    }

    private static void split(int row, int col, int n) {
        if(isSame(row, col, n)){
            sb.append(board[row][col]);
            return;
        }

        // 2,1,3,4 분면
        sb.append("(");
        split(row, col, n/2);
        split(row, col+n/2,n/2);
        split(row+n/2, col, n/2);
        split(row+n/2, col+n/2, n/2);
        sb.append(")");
    }

    private static boolean isSame(int row, int col, int n) {
        char first = board[row][col];
        for(int i=row; i<row+n; i++){
            for(int j = col; j<col+n; j++){
                if(first != board[i][j]) return false;
            }
        }
        return true;
    }
}

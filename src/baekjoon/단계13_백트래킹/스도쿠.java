package baekjoon.단계13_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 스도쿠 {
    static boolean complete = false;
    static int[][] board = new int[9][9];
    static List<int[]> zeros = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j =0; j<9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                // 빈 칸
                if(board[i][j] == 0) zeros.add(new int[]{i, j});
            }
        }
        sudoku(0);

        StringBuilder sb =new StringBuilder();
        for(int[] row : board){
            for(int elm : row){
                sb.append(elm).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void sudoku(int depth) {
        if(depth == zeros.size()){
            complete = true;
            return;
        }
        int[] coor = zeros.get(depth);
        int row = coor[0];
        int col = coor[1];

        for(int i = 1; i<=9; i++){
            if (isPossible(row, col, i)){
                board[row][col] = i;
                sudoku(depth + 1);
                if(complete) break;
                board[row][col] = 0;
            }
        }
    }

    private static boolean isPossible(int row, int col, int num) {
        // 같은 행에 넣으려는 숫자가 이미 있는지 검사.
        for(int i = 0; i<9; i++){
            if(board[row][i] == num) return false;
        }
        // 같은 열에 넣으려는 숫자가 이미 있는지 검사.
        for(int i=0; i<9; i++){
            if(board[i][col] == num) return false;
        }
        // 같은 정사각형에 넣으려는 숫자가 이미 있는지 검사.
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow; i<startRow+3; i++){
            for(int j = startCol; j<startCol+3; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }

}

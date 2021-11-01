package baekjoon.단계20분할정복법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수 {
    static int[][] paper;
    static int[] count = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) paper[i][j] = Integer.parseInt(st.nextToken());
        }

        cut(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for(int c: count){
            sb.append(c).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void cut(int row, int col, int n) {
        if(isAllSame(row, col, n)){
            count[paper[row][col]+1] ++;
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                cut(row + (n*i)/3, col + (n*j)/3, n/3);
            }
        }
    }

    private static boolean isAllSame(int row, int col, int n) {
        int first = paper[row][col];
        for(int i=row; i<row + n; i++){
            for(int j = col; j<col + n; j++){
                if(first !=paper[i][j]) return false;
            }
        }
        return true;
    }
}

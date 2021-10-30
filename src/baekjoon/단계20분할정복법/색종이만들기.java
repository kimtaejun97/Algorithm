package baekjoon.단계20분할정복법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 색종이만들기 {
    static int N;
    static String[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        N = Integer.parseInt(br.readLine());
        paper = new String[N][N];

        for(int i=0; i<N; i++){
            paper[i] = br.readLine().split(" ");
        }

        cut(0, 0, N);
        System.out.print(white+"\n"+blue);
    }
    private static void cut(int row, int col, int n) {
        if(isSameColor(row, col, n)){
            if(paper[row][col].equals("0")) white++;
            else blue ++;
            return;
        }
        // 1,2,3,4 분면
        cut(row, col+n/2,n/2);
        cut(row, col,n/2);
        cut(row+n/2, col,n/2);
        cut(row+n/2, col+n/2,n/2);
    }

    private static boolean isSameColor(int row, int col, int n) {
        String first = paper[row][col];
        for(int i=row; i<row+n; i++){
            for(int j=col; j<col+n; j++){
                if(!first.equals(paper[i][j])) return false;
            }
        }
        return true;
    }
}

package baekjoon.단계16정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

// m개의 사이트 중에서 n개를 중복,순서 없이 뽑는 것. -> mCn
public class 다리놓기 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

           sb.append(combination(m,n)).append("\n");
        }
        System.out.print(sb.toString());

    }

    private static int combination(int m, int n) {
        if(dp[m][n] != 0) return dp[m][n];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=i && j<=n; j++) {
                if(dp[i][j] != 0) continue;
                if(i ==j || j == 0 ) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}

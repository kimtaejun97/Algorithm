package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/*
1 1 1 2 2 3 4 5 7 9 12 16 21 28

[n] =  [n-5] + [n-1]
 */

public class 파도반수열 {
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dfs(n)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static long dfs(int n) {
        if(dp[n] !=0) return dp[n];

        return dp[n] = dfs(n-5) + dfs(n-1);
    }
}

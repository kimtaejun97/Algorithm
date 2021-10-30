package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.System.in;

/*
 nCk = n-1Ck-1 + n-1Ck
 (a + b) % m == (a % m) + (a % m) % m
 */
public class 이항계수2_2 {
    static int MOD =10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BigInteger answer;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=i && j<=k; j++){
                if(i == j || j==0) dp[i][j] = 1;
                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
                }
            }
        }

        System.out.println(dp[n][k] % MOD);
    }
}

package baekjoon.단계20분할정복법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
(N!/K!(N-k)! % MOD)
= ( (N! % MOD) * (K!(N-K)!)^(MOD-2) % MOD ) % MOD
 */
public class 이항계수3 {
    static long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] dp = new long[n+1];

        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] * i) % MOD;
        }
        long answer = (dp[n] * pow(dp[k] * dp[n-k] % MOD, MOD-2) ) % MOD;
        System.out.print(answer);

    }
    public static long pow(long value, long mod){
        if(mod == 1) return value % MOD;

        long half = pow(value, mod/2);

        // (K!(N-K)!)^(MOD-2) % MOD
        if(mod %2 == 0) return (half * half) % MOD;
        else return ((half * half % MOD) * value) % MOD;
    }


}

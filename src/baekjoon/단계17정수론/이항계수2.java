package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 이항계수2 {
    static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BigInteger answer;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        BigInteger[] dp = new BigInteger[n+1];

        dp[0] = dp[1] = new BigInteger("1");
        for(int i=2; i<=n; i++) dp[i] = dp[i-1].multiply(new BigInteger(String.valueOf(i)));

        answer = new BigInteger(
                dp[n].divide(
                        dp[k].multiply(dp[n-k])).toString())
                .mod(new BigInteger(String.valueOf(MOD)));
        System.out.println(answer.toString());

    }
}

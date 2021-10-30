package baekjoon.단계15동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = num[0];
        int max = num[0];

        for(int i=1; i<n; i++){
            // i까지 더한 누적합과, 다시 i부터 누적합을 시작하는 것 중 큰 것.
            dp[i] = Math.max(dp[i-1]+ num[i], num[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

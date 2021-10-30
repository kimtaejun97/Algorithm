package baekjoon.단계15동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        int[] v = new int[n+1];
        int[] weight = new int[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            // 최대 무게가 j물건 무게 일 때. 담을 수 있는 최대 가치.
            for(int j=1; j<=k; j++){
                // i 번째를 담지 못할 때: 지금까지 담은 물건 가치.
                if(weight[i] > j) dp[i][j] = dp[i-1][j];
                // i 번째를 담을 수 있을 때: max(이전까지 담은 최대 가치, i번째 물건 가치 + i 물건을 제외하고 담을 수 있는 최대 가치)
                else dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j- weight[i]]);
            }
        }
        System.out.println(dp[n][k]);
    }
}

package baekjoon.단계15동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        // n 번째 전깃 줄의 전봇대 A위치 0, 전봇대 B위치 1
        int[][] line = new int[n][2];
        int[] dp = new int[n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(line, Comparator.comparingInt(c -> c[0]));
        dp[0] = 1;
        // n 번쨰 전깃줄을 설치했을 때 설치할 수 있는 이전의 전깃줄을 구함.
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                // ai > aj 이면 bi > bj
                if(line[j][1] < line[i][1]) dp[i] = Math.max(dp[i], dp[j]);
            }
            // 자신을 설치.
            dp[i] += 1;
        }

        int numberOfMaxLine = 0;
        for(int i=0; i<n; i++){
            numberOfMaxLine = Math.max(numberOfMaxLine, dp[i]);
        }

        System.out.println(n - numberOfMaxLine);
    }
}

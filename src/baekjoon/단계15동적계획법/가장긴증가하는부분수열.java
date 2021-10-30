package baekjoon.단계15동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        // n 번째 자신을 포함 1, 포함x 0
        int[][] dp = new int[len][2];

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<len; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][1] = 1;

        for(int i =1; i<len; i++){
            int max= 0;
            int lessMax = 0;
            for(int j = 0; j<i; j++){
                // 자신을 수열에 포함하지 않는다면 i 이전까지 중 최대 길이
                max = Math.max(max, Math.max(dp[j][0], dp[j][1]));
                // 자신을 수열에 포함한다면 이전까지 중 i번째 값보다 보다 작고, 자신을 포함하여 만든 부분 수열중 최대 길이.
                // 즉 i보다 작은 수 들로 이루어진 수열중 최대 길이.
                if(arr[j] < arr[i]){
                    lessMax = Math.max(lessMax, dp[j][1]);
                }
            }
            dp[i][0] = max;
            // 자신을 수열에 포함 시킴.
            dp[i][1] = lessMax + 1;
        }
        System.out.println(Math.max(dp[len-1][0], dp[len-1][1]));
    }
}

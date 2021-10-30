package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        // n의 왼쪽 수열, 오른쪽 수열의 길이.
        int[][] dp = new int[len][2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<len; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // left 수열.
        for(int i=1; i<len; i++){
            int leftMax = -1;
            for(int j = 0; j<i; j++){
                if(arr[j] < arr[i]){
                    leftMax = Math.max(leftMax, dp[j][0]);
                }
            }
            dp[i][0] = leftMax + 1;
        }
        // right 수열
        for(int i=len -1; i>=0; i--){
            int rightMax = -1;
            for(int j = i+1; j<len; j++){
                if(arr[j] < arr[i]){
                    rightMax = Math.max(rightMax, dp[j][1]);
                }
                dp[i][1] = rightMax + 1;
            }
        }

        int answer = 1;
        for(int i=0; i<len; i++){
            // 왼쪽 수열 + 오른쪽 수열 + 가운데 수.
            answer = Math.max(answer, dp[i][0] + dp[i][1] + 1);
        }
        System.out.println(answer);
    }
}

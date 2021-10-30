package baekjoon.단계15동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        int[] step = new int[n+1];
        int[] score = new int[n+1];

        for(int i=1; i<=n; i++){
            step[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1){
            System.out.println(step[1]);
            System.exit(0);
        }
        score[1] = step[1];
        score[2] = step[1] + step[2];

        // i 번째 계단까지의 score 의 최대.
        for(int i=3; i<=n; i++){
            // 두 칸을 점프해서 왔을 때, 두칸 점프 후 한칸 이동해서 왔을 때.
            score[i] = Math.max(score[i-2], step[i-1] + score[i-3]) + step[i];
        }
        System.out.println(score[n]);
    }
}

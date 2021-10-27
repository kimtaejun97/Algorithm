package baekjoon.단계15그리디;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] p = new int[n];

        for(int i=0; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        int answer = 0;
        int time = 0;
        for(int i = 0; i<n; i++){
            time += p[i];
            answer += time;
        }
        System.out.println(answer);

    }
}

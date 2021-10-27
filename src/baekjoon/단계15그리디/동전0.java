package baekjoon.단계15그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        int sum = 0;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i=n-1; i>=0; i--){
            count += k / coin[i];
            if(k % coin[i] == 0) break;
            else k = k % coin[i];
        }
        System.out.println(count);
    }
}

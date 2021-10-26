package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 정수1로만들기 {
    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        int count[] = new int[n+1];
        if(n <=3){
            if(n == 1) System.out.println(0);
            else System.out.println(1);
            System.exit(0);
        }

        for(int i=0; i<n+1; i++){
            count[i] = MAX;
        }
        count[2] = count[3] = 1;

        for(int i = 4; i<=n; i++){
            if(i % 3 == 0) count[i] = count[i/3] +1;
            if(i % 2 == 0) count[i] = Math.min(count[i], count[i/2] +1);
            count[i] = Math.min(count[i], count[i-1] +1);
        }
        System.out.println(count[n]);
    }
}

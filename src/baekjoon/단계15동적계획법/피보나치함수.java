package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 피보나치함수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i =0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] zero = new int[n+1];
            int[] one = new int[n+1];
            zero[0] = 1;
            one[0] = 0;
            if(n > 0){
                zero[1] = 0;
                one[1] = 1;
            }

            for(int j = 2; j<=n; j++){
                zero[j] = zero[j-1] + zero[j-2];
                one[j] = one[j-1] + one[j-2];
            }
            sb.append(zero[n]).append(" ").append(one[n]).append("\n");
        }
        System.out.printf(sb.toString());
    }
}

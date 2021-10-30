package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        int[] amount = new int[n+1];
        int[][] drink = new int[n+1][2];

        for(int i=1; i<=n; i++){
            amount[i] = Integer.parseInt(br.readLine());
        }
        drink[1][0] = amount[1];
        drink[1][1] = amount[1];

        for(int i = 2; i<=n; i++){
            drink[i][1] = Math.max(drink[i-1][0] + amount[i], drink[i-1][1]);
            drink[i][0] = Math.max(drink[i-2][0], drink[i-2][1]) + amount[i];
        }
        int answer = Math.max(drink[n][0], drink[n][1]);
        System.out.println(answer);
    }
}

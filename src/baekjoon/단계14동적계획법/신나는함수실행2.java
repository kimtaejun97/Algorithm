package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 신나는함수실행2 {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();

        String input;
        StringTokenizer st;
        while(!(input = br.readLine()).equals("-1 -1 -1")){
            st = new StringTokenizer(input, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            w(a,b,c);

            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append("\n");
        }
        System.out.printf(sb.toString());
    }

    private static int w(int a, int b, int c) {
        if(valid(a,b,c) && dp[a][b][c] != 0) return dp[a][b][c];

        if(a<=0 || b<=0 || c<=0) return 1;
        if(a>20 || b>20 || c>20) return dp[20][20][20] = w(20,20,20);

        if(a < b && b < c){
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1)
                    - w(a, b-1, c);
        }
        else{
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c)
                    + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
        return dp[a][b][c];
    }

    private static boolean valid(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0) return false;
        if(a>20 || b>20 || c>20) return false;

        return true;
    }
}

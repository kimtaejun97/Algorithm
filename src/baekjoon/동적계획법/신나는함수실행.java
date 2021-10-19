package baekjoon.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 신나는함수실행 {
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
            if(a <= 0 || b<= 0 || c <= 0){
                sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(1).append("\n");
                continue;
            }

            int n = Math.max(a, Math.max(b,c));
            int[][][] w;
            if(n > 20) w = new int[21][21][21];
            else w = new int[a+1][b+1][c+1];
            w[0][0][0] = w[0][1][1] = w[0][0][1] = w[0][1][0] = 1;

            for(int i = 0; i<w.length; i++){
                for(int j = 0; j<w[0].length; j++){
                    for(int k = 0; k<w[0][0].length; k++){
                        if(i < j && j < k){
                            w[i][j][k] = w[i][j][k-1] + w[i][j-1][k-1] - w[i][j-1][k];
                        }
                        else{
                            if(i<=0 || j<=0 || k<=0){
                                w[i][j][k] = 1;
                            }
                            else{
                                w[i][j][k] = w[i-1][j][k] + w[i-1][j-1][k] + w[i-1][j][k-1] - w[i-1][j-1][k-1];
                            }
                        }
                    }
                }
            }
            if(n > 20) sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w[20][20][20]).append("\n");

            else sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w[a][b][c]).append("\n");
        }
        System.out.print(sb.toString());
    }


}

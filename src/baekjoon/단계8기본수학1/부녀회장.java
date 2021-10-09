package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //Test Case
        for(int t = 0; t<T; t++){
            int[][] apart = new int[15][15];
            // k층 n호
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            for(int i = 1; i<=n; i++) {
                // 0층 i호에는 i명이 산다.
                apart[0][i] = i;
            }
            for(int i =0; i<=k; i++){
                // n층 1호에는 1명이 산다.
                apart[i][1] = 1;
            }

            for(int i =1; i<=k; i++){
                for(int j=2; j<=n; j++){
                    apart[i][j] = apart[i][j-1] + apart[i-1][j];
                }
            }
            sb.append(apart[k][n]).append("\n");
        }
        System.out.println(sb.toString());
    }
}

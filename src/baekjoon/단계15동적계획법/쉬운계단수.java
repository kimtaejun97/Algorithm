package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 쉬운계단수 {
    static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());

        long[][] count = new long[n+1][10];

        // 한자리 수에서는 한가지의 경우밖에 존재하지 않는다.
        for(int i=1; i<10; i++){
            count[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                // 1 일경우 한 가지
                if(j == 0) count[i][j] = count[i-1][1] % MOD;
                // 8일 경우 한 가지.
                else if(j == 9) count[i][j] = count[i-1][8] % MOD;
                // +- 1일 경우
                else count[i][j] = (count[i-1][j-1] + count[i-1][j+1]) % MOD;
            }
        }

        long answer = 0;
        for(int i=0; i<10; i++){
            answer += count[n][i];
        }
        System.out.println(answer % MOD);
    }
}

package baekjoon.단계15동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
/*
  A C A Y K P
C 0 1 1 1 1 1
A 1 1 2 2 2 2
P 1 1 2 2 2 2
C 1 2 2 2 2 2
A 2 2 3 3 3 3
K 2 2 3 3 4 4
 */
public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        char[][] words = new char[2][];

        words[0] = br.readLine().toCharArray();
        words[1] = br.readLine().toCharArray();
        int lenOfWord1 = words[0].length;
        int lenOfWord2 = words[1].length;

        // 부분 수열의 누적 합
        // 두번째 단어의 row 열까지의 부분수열과 첫 단어의 i행 까지의 부분수열의 중복 부분;
        int[][] dp = new int[lenOfWord1 +1][lenOfWord1 + 1];

        for(int row = 1; row<= lenOfWord1; row++){
            for(int col = 1; col<= lenOfWord1; col++){
                // 첫 단어의 row번째 문자와 두번째 단어의 col번째 단어가 같다면 이전 부분 수열의 누적합에 1을 더해준다.
                if(words[1][row-1] == words[0][col-1]) dp[row][col] = dp[row-1][col-1] + 1;
                // 다르다면 첫 단어의 이전 부분 수열의 누적합과, 두번쨰 단어의 이전 부분 수열의 누적합중 큰 것.
                else dp[row][col] = Math.max(dp[row][col-1], dp[row-1][col]);
            }
        }
        System.out.println(dp[lenOfWord1][lenOfWord1]);
    }
}

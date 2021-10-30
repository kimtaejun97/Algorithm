package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 조합0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 소인수 분해 했을 때 2와 5의 수를 구한다. n!/ m!(n-m)! 이므로 수만큼 빼준다.
        int numOfTwo = getNumOfPow(n,2) - getNumOfPow(m,2) - getNumOfPow(n - m,2);
        int numOfFive = getNumOfPow(n,5) - getNumOfPow(m,5) - getNumOfPow(n - m,5);

        System.out.print(Math.min(numOfFive, numOfTwo));

    }
    private static int getNumOfPow(int num, int target) {
        int count = 0;
        while (num >= target) {
            count += num / target;
            num /= target;
        }
        return count;
    }
}

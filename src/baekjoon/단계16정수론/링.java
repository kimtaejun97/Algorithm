package baekjoon.단계16정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;
/*
양쪽 반 지름을 최대공약수로 나눠줌.
 */
public class 링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int first = 0;
        int num = 0;
        int GCD = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        first = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++){
            num = Integer.parseInt(st.nextToken());
            GCD = gcd(first, num);
            sb.append(first/GCD).append("/").append(num/GCD).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int gcd(int a, int b) {
        if(b <= 0) return a;
        return gcd(b, a % b);
    }
}

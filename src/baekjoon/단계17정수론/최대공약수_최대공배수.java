package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;
/*
유클리드 호제법.

 */
public class 최대공약수_최대공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int LCM = a * b;

        int r = a % b;
        while(r > 0){
            a = b;
            b = r;
            r = a % b;
        }
        int GCD = b;
        LCM /= GCD;

        StringBuilder sb = new StringBuilder();
        sb.append(GCD).append("\n").append(LCM);
        System.out.print(sb.toString());
    }
}

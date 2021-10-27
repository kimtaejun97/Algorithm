package baekjoon.단계16정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 최대공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(b > a){
                int buff = a;
                a = b;
                b = buff;
            }
            int GCD = gcd(a,b);
            sb.append(a * b /GCD).append("\n");
        }
        System.out.print(sb.toString());

    }

    private static int gcd(int a, int b) {
        if(b <= 0) return a;
        return gcd(b, a % b);
    }
}

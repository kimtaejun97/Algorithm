package baekjoon.단계20분할정복법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
(a * a) % c == ((a%c) * (a%c)) % c
 */
public class 곱셈 {
    static int div;
    static int A,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        div = A % C;

        System.out.println(mul(b));
    }

    private static long mul(int b) {
        if(b == 1) return div;
        long value = mul(b/2);
        if(b % 2 == 0) return value * value % C;
        else return (value * value % C) * A % C;
    }
}

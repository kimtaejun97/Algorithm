package baekjoon.단계9재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 피보나치수5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());

        int nFac = fibo(n);
        System.out.println(nFac);

    }

    private static int fibo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibo(n-1) + fibo(n-2);
    }
}

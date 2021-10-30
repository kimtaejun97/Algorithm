package baekjoon.단계10재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 팩토리얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        
        int nFac = factorial(n);
        System.out.println(nFac);
    }

    private static int factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

}

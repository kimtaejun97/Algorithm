package baekjoon.단계16정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;
/*
n!/k!(n-k)!
 */
public class 이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int top = 1;
        for(int i=n; i>n-k; i--){
            top *= i;
        }

        int bottom = 1;
        for(int i=k; i>1; i--){
            bottom *= i;
        }

        System.out.println(top/bottom);
    }
}

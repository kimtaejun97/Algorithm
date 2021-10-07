package baekjoon.단계3For;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계산3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 1; i <= t; i++){
            String[] value = br.readLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            System.out.println(String.format("Case #%d: %d + %d = %d",i,a,b,a+b));
        }
    }
}

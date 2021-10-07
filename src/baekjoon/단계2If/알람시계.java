package baekjoon.단계2If;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알람시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]) + 24;
        int m = Integer.parseInt(input[1]);

        if(m < 45){
            h = (h - 1);
            m = 60 + m;
        }
        h %= 24;
        m -= 45;
        System.out.println(String.format("%d %d", h,m));
    }
}

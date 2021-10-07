package baekjoon.단계3FOR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++){
            String[] value = br.readLine().split(" ");
            System.out.println(Integer.parseInt(value[0]) + Integer.parseInt(value[1]));
        }
    }
}

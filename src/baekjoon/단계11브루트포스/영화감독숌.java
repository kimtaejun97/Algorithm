package baekjoon.단계11브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num =666;
        while(n > 0){
            String strNum = String.valueOf(num++);
            if(strNum.contains("666")) n--;
        }
        System.out.println(num-1);
    }
}

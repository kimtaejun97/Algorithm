package baekjoon.단계5배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] flag = new boolean[42];
        int count = 0;

        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            int remainder = num % 42;
            flag[remainder] = true;
        }

        for(boolean f : flag){
            if(f){
                count ++;
            }
        }
        System.out.println(count);
    }
}

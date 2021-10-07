package baekjoon.단계5배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값 {
    private static final int MIN = 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = MIN;
        int idx = -1;
        int number;

        for(int i=1; i<=9; i++){
            number = Integer.parseInt(br.readLine());
            if(number > max){
                max = number;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx);

    }
}

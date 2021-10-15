package baekjoon.단계11브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String n = br.readLine();
        int num = Integer.parseInt(n);

        int cons = 0;
        for(int i=num - n.length() * 9; i<num; i++){
            int candidate = i;

            int sum = candidate;
            while(candidate > 0){
                sum += candidate % 10;
                candidate /= 10;
            }

            if(sum == num){
                cons = i;
                break;
            }
        }
        System.out.println(cons);
    }
}

package baekjoon.단계5배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[10];
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int mul = a * b * c;
        String result = String.valueOf(mul);

        for(char v : result.toCharArray()){
            int idx = Integer.valueOf(String.valueOf(v));
            count[idx] ++;
        }
        StringBuilder sb = new StringBuilder();

        for(int v : count){
            sb.append(v).append("\n");
        }
        System.out.println(sb.toString());



    }
}

package baekjoon.단계1출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a =  Integer.parseInt(br.readLine());
        String b = br.readLine();
        int sum = 0;

        StringBuilder sb = new StringBuilder();
        char[] value = b.toCharArray();
        for(int  i = value.length-1; i>=0; i--){
            int cul = a * Integer.parseInt(String.valueOf(value[i]));
            sb.append(cul).append("\n");
            sum += cul * Math.pow(10,b.length()-1 - i);
        }
        sb.append(sum);

        System.out.print(sb.toString());
    }
}

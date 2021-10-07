package baekjoon.단계4While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb  = new StringBuilder();
        while((input = br.readLine()) != null) {
            String[] value = input.split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            sb.append(a+b).append("\n");
        }
        System.out.println(sb.toString());
    }
}

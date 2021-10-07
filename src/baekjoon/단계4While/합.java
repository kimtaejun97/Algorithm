package baekjoon.단계4While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = br.readLine()).equals("0 0")) {
            String[] value = input.split(" ");
            System.out.println(Integer.parseInt(value[0]) + Integer.parseInt(value[1]));
        }
    }
}

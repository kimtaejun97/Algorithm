package baekjoon.단계7문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();


        for(int i =0; i<n; i++){
            sum += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        System.out.println(sum);


    }
}

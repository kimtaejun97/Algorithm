package baekjoon.단계11브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합 {
    public static void main(String[] args) throws IOException {

        int sum=0;
        int constructor = 0;
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stringNumber = br.readLine();

        int maxGap = stringNumber.length() * 9;
        int number = Integer.valueOf(stringNumber);

        int start = number - maxGap;

        for(int estimate = start; estimate<number-2; estimate++){
            String stringEstimate = String.valueOf(estimate);
            sum = estimate;
            for(int i =0; i<stringEstimate.length(); i++){
                String substring = String.valueOf(stringEstimate.charAt(i));
                sum += Integer.valueOf(substring);
            }

            if(sum == number){
                answer = estimate;
                break;
            }

        }

        System.out.println(answer);







    }
}

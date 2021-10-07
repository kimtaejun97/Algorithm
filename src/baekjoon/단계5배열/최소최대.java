package baekjoon.단계5배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최소최대 {
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int firstNum =Integer.parseInt(nums[0]);
        int max = firstNum;
        int min = firstNum;

        for(int i = 1; i< nums.length; i++){
            int number = Integer.parseInt(nums[i]);
            if(number > max) max = number;
            else if(number < min) min = number;
        }

        System.out.println(String.format("%d %d", min, max));
    }
}

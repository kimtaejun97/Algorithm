package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);

        }
        System.out.println(max * min);
    }
}

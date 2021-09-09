package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(answer);

        StringBuilder sb = new StringBuilder();
        for(int num : answer){
            sb.append(num).append("\n");
        }

        System.out.print(sb.toString());
    }
}

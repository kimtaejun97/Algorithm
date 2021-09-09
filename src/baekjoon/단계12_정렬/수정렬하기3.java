package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3 {
    public static void main(String[] args) throws IOException {
        //counting sort
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] counting = new int[100001];

        for(int i=0; i<n; i++){
            counting[Integer.parseInt(br.readLine())] ++;
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<100001; i++){
            if(counting[i] != 0){
                sb.append((String.valueOf(i) + "\n").repeat(counting[i]));
            }
        }

        System.out.print(sb.toString());

    }
}

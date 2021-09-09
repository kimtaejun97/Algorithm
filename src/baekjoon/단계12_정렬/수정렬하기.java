package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            que.add(Integer.valueOf(br.readLine()));
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!que.isEmpty()){
            stringBuilder.append(que.poll()).append("\n");
        }

        System.out.print(stringBuilder.toString());
    }

}

package baekjoon.단계19큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.in;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList();
        for(int i=1;i<=n; i++){
            q.add(i);
        }
        while(q.size() != 1){
            q.poll();
            q.add(q.poll());
        }
        System.out.print(q.poll());
    }
}

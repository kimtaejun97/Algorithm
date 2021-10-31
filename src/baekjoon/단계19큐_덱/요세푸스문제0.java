package baekjoon.단계19큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList();
        for(int i=1; i<=n; i++) q.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            for(int i=0; i<k-1; i++){
                q.add(q.poll());
            }
            int removeElm = q.remove();
            if(q.isEmpty()) sb.append(removeElm).append(">");
            else sb.append(removeElm).append(", ");
        }
        System.out.print(sb.toString());
    }
}

package baekjoon.단계19큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.in;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        Deque deque = new ArrayDeque();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].equals("push_front")) deque.offerFirst(cmd[1]);
            else if(cmd[0].equals("push_back")) deque.offerLast(cmd[1]);
            else if(cmd[0].equals("pop_front")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            }
            else if(cmd[0].equals("pop_back")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollLast()).append("\n");
            }
            else if(cmd[0].equals("size")) sb.append(deque.size()).append("\n");
            else if(cmd[0].equals("empty")){
                if(deque.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(cmd[0].equals("front")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            }
            else if(cmd[0].equals("back")){
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}

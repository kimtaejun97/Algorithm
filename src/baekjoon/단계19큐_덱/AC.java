package baekjoon.단계19큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class AC {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            Dq dq = new Dq();
            char[] cmds = br.readLine().toCharArray();
            int arrLength = Integer.parseInt(br.readLine());

            // 숫자만 담은 배열
            String[] arr = br.readLine()
                    .replaceAll("[\\[\\]]", "")
                    .split(",");
            if(arrLength !=0) dq.addData(arr);
            else dq.addData(null);

            boolean canDiscard = true;
            for(char cmd : cmds){
                if(cmd == 'R') dq.reverse();
                else if(cmd == 'D'){
                    // 큐가 비어있으면 false
                    canDiscard = dq.pollFirst();
                    if(!canDiscard) break;
                }
            }
            if(!canDiscard) sb.append("error\n");
            else dq.appendResult();
        }
        System.out.print(sb.toString());
    }

    static class Dq{
        private boolean reverse = false;
        private Deque<String> deque = new ArrayDeque();

        public void addData(String[] arr){
            if(arr == null) return;

            for(String n : arr){
                deque.offer(n);
            }
        }
        public void reverse(){reverse = !reverse;}
        public boolean pollFirst(){
            if(deque.isEmpty()) return false;

            if(reverse) deque.pollLast();
            else deque.pollFirst();
            return true;
        }
        public void appendResult(){
            sb.append("[");
            Iterator it;
            if(reverse) it = deque.descendingIterator();
            else it = deque.iterator();

            while(it.hasNext()){
                String n = (String)it.next();

                if(it.hasNext()) sb.append(n).append(",");
                else sb.append(n);
            }
            sb.append("]\n");
        }
    }
}

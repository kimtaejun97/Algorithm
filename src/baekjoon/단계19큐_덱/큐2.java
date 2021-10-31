package baekjoon.단계19큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        MyQueue q = new MyQueue();

        for(int i=0; i<n; i++){
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].equals("push")) q.push(Integer.parseInt(cmd[1]));
            else if(cmd[0].equals("pop")) sb.append(q.pop()).append("\n");
            else if(cmd[0].equals("size")) sb.append(q.size()).append("\n");
            else if(cmd[0].equals("empty")) sb.append(q.empty()).append("\n");
            else if(cmd[0].equals("front")) sb.append(q.front()).append("\n");
            else if(cmd[0].equals("back")) sb.append(q.back()).append("\n");
        }
        System.out.print(sb.toString());
    }
    static class MyQueue{
        private int[] q = new int[2000000];
        private int topPointer = 0;
        private int pushPointer = 0;

        public void push(int n){
            q[pushPointer++] = n;
            if(isEndPoint(pushPointer)) pushPointer = 0;
        }
        public int pop(){
            if(empty() == 1) return -1;

            int elm = q[topPointer++];
            if(isEndPoint(topPointer)) topPointer = 0;
            return elm;
        }
        public int size(){
            return pushPointer - topPointer;
        }
        public int empty(){
            if(pushPointer == topPointer) return 1;
            return 0;
        }
        public int front(){
            if(empty() == 1) return -1;
            return q[topPointer];
        }
        public int back(){
            if(empty() == 1) return -1;
            return q[pushPointer - 1];
        }

        private boolean isEndPoint(int p) {
            if(p >= q.length) return true;
            return false;
        }

    }
}

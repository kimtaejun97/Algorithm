package baekjoon.단계17스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] cmd = br.readLine().split(" ");

            if(cmd[0].equals("push")){
                stack.push(Integer.parseInt(cmd[1]));
            }
            else if(cmd[0].equals("pop")){
                sb.append(stack.pop()).append("\n");
            }
            else if(cmd[0].equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(cmd[0].equals("empty")){
                sb.append(stack.empty()).append("\n");
            }
            // top
            else{
                sb.append(stack.top()).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
    static class Stack{
        private List<Integer> stack = new ArrayList<>();

        public void push(int n){stack.add(n); }

        public int pop(){
            if(stack.isEmpty()) return -1;
            return stack.remove(stack.size()-1);
        }

        public int size(){return stack.size();}

        public int empty(){
            return stack.isEmpty()? 1:0;
        }

        public int top(){
            if(stack.isEmpty()) return -1;
            return stack.get(stack.size()-1);
        }
    }
}

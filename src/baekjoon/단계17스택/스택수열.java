package baekjoon.단계17스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String answer = "";
        Stack<Integer> st = new Stack();
        int n = Integer.parseInt(br.readLine());
        int[] targets = new int[n];

        for(int i=0; i<n; i++) targets[i] = Integer.parseInt(br.readLine());

        int p = 1;
        for(int target : targets){
            if(target < p && st.search(target) == -1){
                answer ="NO";
                break;
            }
            else if(target >= p){
                while(p <= target){
                    st.push(p++);
                    sb.append("+\n");
                }
                st.pop();
                sb.append("-\n");

            }
            else if(target < p){
                while(!st.isEmpty() && st.peek() >= target){
                    st.pop();
                    sb.append("-\n");
                }
            }
        }
        sb.append("-\n".repeat(st.size()));
        System.out.println(answer.equals("")? sb.toString() : answer);
    }
}

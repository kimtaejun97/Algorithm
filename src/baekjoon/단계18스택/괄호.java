package baekjoon.단계18스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        Stack<Integer> st;

        for(int i=0; i<t; i++){
            st = new Stack();
            char[] brace = br.readLine().toCharArray();
            for(int j=0; j< brace.length; j++){
                if(brace[j] == '(') st.push(1);
                else{
                    if(st.isEmpty()) {
                        st.push(1);
                        break;
                    }
                    st.pop();
                }
            }
            if(!st.isEmpty()) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
        System.out.print(sb.toString());
    }
}

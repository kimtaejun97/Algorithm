package baekjoon.단계18스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] result = new String[n];
        Stack<Integer> st = new Stack<>();
        Stack<Integer> index = new Stack<>();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            result[i] = "-1";
            int target = Integer.parseInt(stringTokenizer.nextToken());

            if(!st.isEmpty() && target > st.peek()){
                while(!st.isEmpty() && target > st.peek()){
                    result[index.pop()] = String.valueOf(target);
                    st.pop();
                }
            }
            st.push(target);
            index.push(i);
        }
        String answer = String.join(" ",result);
        System.out.print(answer);
    }
}

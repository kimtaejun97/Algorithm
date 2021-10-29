package baekjoon.단계17스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) st.pop();
            else st.push(num);
        }
        int answer = st.stream().mapToInt(num -> num).sum();
        System.out.println(answer);
    }
}

package baekjoon.단계17스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class 균형잡힌세상 {
    static Stack<Integer> st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        String sentence;
        while(!(sentence= br.readLine()).equals(".")){
            st = new Stack<>();
            if(!isValid(sentence)) sb.append("no").append("\n");
            else sb.append("yes").append("\n");
        }
        System.out.print(sb.toString());
    }

    private static boolean isValid(String s) {
        char[] sentence = s.toCharArray();

        for(int i=0; i<sentence.length; i++){
            // (:1, [:2
            if(sentence[i] == '(') st.push(1);
            else if(sentence[i] == '[') st.push(2);

            else if(sentence[i] == ')'){
                if(st.isEmpty()) return false;
                // () 사이에 [가 혼자 있는 경우.
                else if(st.peek() == 2) return false;
                else st.pop();
            }
            else if(sentence[i] == ']'){
                if(st.isEmpty()) return false;
                else if(st.peek() == 1) return false;
                else st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}

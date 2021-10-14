package programmers.광탈방지Java;

import java.util.Stack;

/*
DFS
 */
public class 올바른괄호의갯수 {
    static int N;
    static String[] selectedBrackets;
    static int answer = 0;

    public int solution(int n) {
        N = n;
        dfs(1);

        return answer;
    }
    private void dfs(int depth) {

        // 끝은 무조건 닫힌 괄호.
        if(depth == N * 2){
            selectedBrackets[depth] = ")";
            if(isCorrectBrackets()) answer ++;
        }
        // 시작은 무조건 열린 괄호
        else if(depth == 1){
            selectedBrackets = new String[2*N + 1];
            selectedBrackets[depth] = "(";

            dfs(depth+1);
        }
        else{
            selectedBrackets[depth] = "(";
            dfs(depth +1);
            selectedBrackets[depth] = ")";
            dfs(depth +1);
        }
    }
    private boolean isCorrectBrackets() {
        Stack<Integer> stack = new Stack();
        for(int i=1; i<selectedBrackets.length; i++){
            if(selectedBrackets[i].equals("(")) stack.push(1);
            else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}

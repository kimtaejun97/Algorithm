package programmers.광탈방지Java;

/*
Stack
 */

import java.util.Stack;

public class 올바른괄호의갯수2 {
    static int N;
    static int answer = 0;

    public int solution(int n) {
        N = n;
        dfs();

        return answer;
    }

    private void dfs() {
        Stack<Node> stack = new Stack();
        stack.push(new Node(0,0));

        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            if(currNode.right > currNode.left) continue;
            if(currNode.left > N || currNode.right > N) continue;
            if(currNode.left == N && currNode.right == N){
                answer ++;
                continue;
            }
            stack.push(new Node(currNode.left+1, currNode.right));
            stack.push(new Node(currNode.left, currNode.right+1));
        }
    }
    class Node{
        int left = 0;
        int right = 0;

        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }

    }
}



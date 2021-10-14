package programmers.광탈방지Java;
/*
재귀, 가장 속도 빠름.
 */
public class 올바른괄호의갯수3 {
    static int answer =0;
    static int N;

    public int solution(int n) {
        N = n;
        dfs(0, 0);
        return answer;
    }

    public void dfs(int left, int right) {
        if(left > N || right > N) return;
        if(left < right) return;
        if(left == N && right == N) {
            answer++;
            return;
        }
        dfs(left + 1, right);
        dfs(left, right + 1);
    }
}

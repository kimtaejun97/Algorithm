package baekjoon.단계14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 연산자끼워넣기 {
    static int[] numbers;
    static char[] op = new char[]{'+', '-', '*', '/'};
    static int[] numberOfOp = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static char[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        selected = new char[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++){
            numberOfOp[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.print(max + "\n" + min);
    }

    private static void dfs(int depth) {
        if(depth == N-1){
            int result = numbers[0];
            for(int i = 0; i<N-1; i++){
                switch (selected[i]){
                    case '+': result += numbers[i+1]; break;
                    case '-': result -= numbers[i+1]; break;
                    case '*': result *= numbers[i+1]; break;
                    case '/': result /= numbers[i+1];
                }
            }
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for(int i=0; i<op.length; i++){
            if(numberOfOp[i] > 0){
                selected[depth] = op[i];
                numberOfOp[i] --;
                dfs(depth +1);
                numberOfOp[i] ++;
            }
        }
    }
}

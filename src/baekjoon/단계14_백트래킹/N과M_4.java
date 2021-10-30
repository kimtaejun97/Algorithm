package baekjoon.단계14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_4 {
    static int N, M;
    static int firstNumber = 1;
    static String[] selectedSequence;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selectedSequence = new String[M+1];
        selectedSequence[1] = "";

        dfs(1);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if(depth == M){
            for(int i = firstNumber; i<=N; i++){
                sb.append(selectedSequence[depth]).append(i).append("\n");
            }
            return;
        }
        int start = firstNumber;
        for(int i = start; i<=N; i++){
            selectedSequence[depth+1] = selectedSequence[depth] + i + " ";
            dfs(depth+1);
            firstNumber ++;
        }
        firstNumber = start;
    }
}

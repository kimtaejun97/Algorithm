package baekjoon.단계14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_3 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static String[] selectedSequence;
    static String[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       numbers = new String[N];
       selectedSequence = new String[M+1];
       selectedSequence[1] = "";

        for(int i= 1; i<=N; i++){
            numbers[i-1] = String.valueOf(i);
        }

        sequence(1);
        System.out.println(sb.toString());
    }

    private static void sequence(int depth) {
        List<String> sequences = new ArrayList<>();

        if(depth == M){
            for (String number : numbers){
                sb.append(selectedSequence[depth]).append(number).append("\n");
            }
            return;
        }
        for(int i = 0; i<numbers.length; i++){
            selectedSequence[depth+1] = selectedSequence[depth] + numbers[i] + " ";
            sequence(depth+1);
        }

    }
}

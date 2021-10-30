package baekjoon.단계13_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++){
            numbers.add(String.valueOf(i));
        }
        List<String> sequences = sequence(numbers, m, "");

        StringBuilder sb = new StringBuilder();
        for(String sequence : sequences){
            sb.append(sequence).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static List<String> sequence(List<String> numbers, int m, String currSequence) {
        List<String> sequences = new ArrayList<>();

        // 종료조건
        if(m == 1){
            for(String number: numbers){
                sequences.add(currSequence + number);
            }
            return sequences;
        }
        // 재귀 호출
        for(int i = 0; i < numbers.size(); i++){
            String nextSequence = currSequence + numbers.get(i) +" ";
            List<String> nextNumbers = new ArrayList<>(numbers.subList(i+1, numbers.size()));
            sequences.addAll(sequence(nextNumbers, m-1, nextSequence));
        }

        return sequences;
    }

}

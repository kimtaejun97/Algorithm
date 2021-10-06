package baekjoon.단계13_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력:N M
 */
public class N과M_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        List<String> numbers = new ArrayList<>();

        // 수열에 들어갈 원소 배열 1~n
        for(int i = 1; i<=n; i++){
            numbers.add(String.valueOf(i));
        }

        List<String> sequences = sequence(numbers, m, "");
        String result = String.join("\n", sequences);
        System.out.print(result);
    }

    public static List<String> sequence(List<String> numbers, int count, String currSequence){
        List<String> sequences = new ArrayList<>();

        // 마지막 순서
        if(count == 1){
            for(String number : numbers){
                sequences.add(currSequence +number);
            }
            return sequences;
        }

        List<String> remainderNumber = new ArrayList<>();

        // 재귀에서 다음 수 선택한 수열 반환받아 추가.
        for(int i = 0; i<numbers.size(); i++){
            remainderNumber.addAll(numbers);
            String choice = remainderNumber.remove(i)+ " ";
            sequences.addAll(sequence(remainderNumber, count-1, currSequence + choice));

            remainderNumber.clear();
        }
        return sequences;
    }
}

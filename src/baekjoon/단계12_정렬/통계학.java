package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class 통계학 {
    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> freq = new HashMap<>();
        int sum = 0;
        int max =-4001;
        int min = 4001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1){
            String value= numbers[0] + "\n";
            System.out.print(value.repeat(3));
            System.out.println(0);
        }
        else{
            // 산술평균, 최대, 최소
            for(int num : numbers){
                sum+= num;
                freq.put(num, freq.getOrDefault(num,0) + 1);
                if( num < min){
                    min = num;
                }
                if(num > max){
                    max = num;
                }
            }

            // 산술 평균
            System.out.println(Math.round((double)sum / numbers.length));

            // 중앙값
            Arrays.sort(numbers);
            System.out.println(numbers[numbers.length/2]);

            // 최빈값
            List<Map.Entry<Integer, Integer>> sorted = freq.entrySet().stream()
                    .sorted(new Comparator<Map.Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                            if(c1.getValue() > c2.getValue()){
                                return -1;
                            }
                            else if(c1.getValue() == c2.getValue()){
                                if(c1.getKey() <= c2.getKey()){
                                    return -1;
                                }
                                else{
                                    return 1;
                                }
                            }
                            else{
                                return 1;
                            }
                        }
                    })
                    .collect(Collectors.toList());
            if(sorted.get(0).getValue() == sorted.get(1).getValue()){
                System.out.println(sorted.get(1).getKey());
            }
            else{
                System.out.println(sorted.get(0).getKey());

            }

            // 범위
            System.out.println(max-min);
        }





    }
}

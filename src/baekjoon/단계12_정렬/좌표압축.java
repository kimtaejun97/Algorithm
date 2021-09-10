package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer. parseInt(br.readLine());

        String coorString = br.readLine();
        String[] split = coorString.split(" ");
        List<Integer> coors = new ArrayList<>();
        List<Integer> uniqueCoors = new ArrayList<>();
        for(int i=0; i<t; i++){
            coors.add(Integer.parseInt(split[i]));
        }

        // 정렬
        List<Integer> sorted = coors.stream()
                .sorted()
                .collect(Collectors.toList());

        // 중복 제거
        uniqueCoors.add(sorted.get(0));
        for(int i=1; i<sorted.size(); i++){
            int target = sorted.get(i);
            if(target > sorted.get(i-1)){
                uniqueCoors.add(target);
            }
        }

        // 인덱스 == 자기보다 작은 요소의 수.
        StringBuilder sb = new StringBuilder();
        for(int c : coors){
            int start = 0;
            int end = uniqueCoors.size() -1;
            int mid = 0;
            int index = 0;

            // 이분 탐색.
            while(start <= end){
                mid = (start + end) / 2;
                if(uniqueCoors.get(mid) == c){
                    index = mid;
                    break;
                }
                else if(uniqueCoors.get(mid) > c){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
            sb.append(index).append(" ");
        }
        System.out.println(sb.toString());
    }
}

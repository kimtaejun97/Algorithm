package baekjoon.단계16정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int answer = 1;
            int numberOfClothes = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            for(int j=0; j<numberOfClothes; j++){
                String[] nameKinds = br.readLine().split(" ");
                clothes.put(nameKinds[1], clothes.getOrDefault(nameKinds[1], 0)+1);
            }
            for(int num : clothes.values()){
                // 부위별종류 + 해당 부위를 안입었을 때.
                answer *= num+1;
            }
            // 전부 안입는 경우
            sb.append(answer-1).append("\n");
        }
        System.out.print(sb.toString());
    }
}

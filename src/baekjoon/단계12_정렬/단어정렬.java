package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();
        for(int i=0; i<t; i++){
            words.add(br.readLine());
        }

        List<String> sorted = words.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String c1, String c2) {
                if(c1.length() < c2.length()){
                    return -1;
                }
                else if(c1.length() == c2.length()){
                    if(c1.compareTo(c2) <= 0){
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
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(String word : sorted){
            sb.append(word).append("\n");
        }
        System.out.print(sb.toString());
    }
}

package baekjoon.단계7문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어공부 {
    private static final int MAX_LENGTH = 1000000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max=-1;
        char result = 0;

        //모든 알파벳의 카운트 횟수 0으로 초기화.
        HashMap<Character,Integer> alphabets = new HashMap(){{
                for(char c = 'A'; c<='Z'; c++)
                    put(c,0);
            }};

        String word = br.readLine().toUpperCase();
        if(word.length()>MAX_LENGTH){
            throw new IllegalArgumentException("단어가 너무 깁니다.");
        }

        //알파벳 카운트
        for(char c : word.toCharArray()){
            alphabets.put(c,alphabets.get(c)+1);
        }
        
        for(Map.Entry<Character, Integer> alphabet : alphabets.entrySet()){
            int value = alphabet.getValue();
            if(value > max){
                max = value;
                result = alphabet.getKey();
            }
            else if(max ==value){
                result='?';
            }
        }
        System.out.println(result);

        //Map 내림차순 정렬
//        List<Map.Entry<Character, Integer>> alphabetOrderByDesc = new ArrayList<>(alphabets.entrySet());
//
//        Collections.sort(alphabetOrderByDesc, new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> t1, Map.Entry<Character, Integer> t2) {
//                return t2.getValue().compareTo(t1.getValue());
//            }
//        });
//
//        if(alphabetOrderByDesc.get(0).getValue() == alphabetOrderByDesc.get(1).getValue()){
//            System.out.println("?");
//        }
//        else
//            System.out.println(alphabetOrderByDesc.get(0).getKey());
        

    }
}

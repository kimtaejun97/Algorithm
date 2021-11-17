package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. 다음 문자가 남아있다면 다음 문자까지 더하여 문자열을 만듦
    2.1 다음 글자까지도 존재할경우 1로.
    2.2 존재하지 않을경우 이전까지 문자열의 색인 번호를 출력하고, 현재 문자열을 사전에 등록
2. 다음 idx 탐색(마지막으로 더한 문자의 idx)

 */
public class 압축 {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();

        // 기본 대문자 사전에 등록.
        int dictionaryIdx = 1;
        for(char c= 'A'; c<='Z'; c++){
            dictionary.put(String.valueOf(c), dictionaryIdx++);
        }

        char[] message = msg.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i<message.length; i++){
            sb.append(message[i]);
            if(i+1 <message.length){
                String nextString = sb.toString() + message[i+1];
                if(dictionary.get(nextString) == null){
                    answer.add(dictionary.get(sb.toString()));
                    dictionary.put(nextString, dictionaryIdx++);
                    sb = new StringBuilder();
                }
            }
            else answer.add(dictionary.get(sb.toString())); // 마지막 문자
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

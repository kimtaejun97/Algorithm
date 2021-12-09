package codility;

import java.util.HashMap;
import java.util.Map;

/*
S의 문자들을 조합하여 L의 단어를 만들 수 있는 최대 수.
 */
public class 문자의조합과단어수 {
    public int solution(String S, String[] L) {
        int answer = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        for(char c : S.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        }

        for(String word : L){
            int count = Integer.MAX_VALUE;
            Map<Character, Integer> alphabetCount = new HashMap<>();
            for(char c : word.toCharArray()){
                alphabetCount.put(c, alphabetCount.getOrDefault(c, 0)+1);
            }

            for(Map.Entry<Character, Integer> entry : alphabetCount.entrySet()){
                Integer numberOfAlphabet = sMap.get(entry.getKey());
                if(numberOfAlphabet == null){
                    count = Integer.MAX_VALUE;
                    break;
                }

                count = Math.min(count, numberOfAlphabet / entry.getValue());

            }
            if(count != Integer.MAX_VALUE){
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}

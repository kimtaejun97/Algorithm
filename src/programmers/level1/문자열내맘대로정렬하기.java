package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 문자열내맘대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        int p = 0;

        Arrays.sort(strings);

        Map<Character, List<String>> indexN = new HashMap<>();
        for (String string : strings) {
            char charN = string.charAt(n);
            if(indexN.containsKey(charN)){
                indexN.get(charN).add(string);
            }
            else{
                ArrayList<String> duplicate = new ArrayList<>(){};
                duplicate.add(string);
                indexN.put(charN, duplicate)
            }
        }
        List<List<String>> sorted = indexN.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getValue())
                .collect(Collectors.toList());

        for(List<String> sList : sorted){
            for (String s : sList) {
                answer[p++] = s;
            }
        }

        return answer;
    }
}

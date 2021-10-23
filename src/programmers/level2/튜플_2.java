package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class 튜플_2 {
    public int[] solution(String s) {
        int[] answer;
        Map<Integer, Integer> elmCount = new HashMap<>();

        s = s.replaceAll("[{]{1,}", "");
        s = s.replaceAll("[}]{1,}","");
        StringTokenizer stringTokenizer = new StringTokenizer(s,",");

        while(stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            int elmValue = Integer.parseInt(token);
            elmCount.put(elmValue, elmCount.getOrDefault(elmValue,0)+1);
        }
        answer = new int[elmCount.size()];
        List<Map.Entry<Integer, Integer>> orderByValue = elmCount.entrySet().stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());

        for(int i = 0; i< orderByValue.size(); i++){
            answer[i] = orderByValue.get(i).getKey();
        }

        return answer;
    }

}

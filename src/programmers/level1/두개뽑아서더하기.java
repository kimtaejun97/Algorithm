package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> unique = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                unique.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = unique.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}

package codility;

import java.util.HashSet;
import java.util.Set;

public class 가장작은등장하지않은정수 {
    public int solution(int[] A) {
        int answer = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            if(a > 0){
                max = Math.max(max, a);
                set.add(a);
            }
        }
        if(set.isEmpty()) return 1;

        for(int i =1; i<=max; i++){
            if(!set.contains(i)){
                answer = i;
                break;
            }
        }
        if(answer == 0) answer = max+1;
        return answer;
    }
}

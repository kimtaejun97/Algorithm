package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Set set = new HashSet();
        for(int n : nums) set.add(n);

        return Math.min(set.size(), nums.length/2 );
    }

}

package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> nums = new ArrayList<>();
        int prev = -1;
        for(int num : arr){
            if(prev != num ){
                nums.add(num);
                prev = num;
            }
        }
        return nums.stream().mapToInt(i->i).toArray();
    }
}

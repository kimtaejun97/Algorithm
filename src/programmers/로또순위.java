package programmers;

public class 로또순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer= {6,6};
        int correctCount =0;
        int zeroCount =0;

        for(int mynum :lottos){
            if(mynum == 0 )
                zeroCount++;
            else{
                for(int num : win_nums){
                    if(mynum ==num) {
                        correctCount++;
                        break;
                    }
                }
            }
        }

        if (correctCount+zeroCount >=2)
            answer[0] =7-correctCount-zeroCount;
        if(correctCount >=2)
            answer[1] = 7-correctCount;

        return answer;
    }
}

/*

import java.util.Arrays;
import java.util.stream.LongStream;

class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
}
 */

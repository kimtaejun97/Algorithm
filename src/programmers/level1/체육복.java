package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 탐욕법
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] isLost = new boolean[n+2];

        List<Integer> extra = Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toList());

        for(int idx : lost){
            if(!extra.contains(idx)){
                isLost[idx] = true;
            }else{
                extra.remove((Integer)idx);
            }
        }

        Collections.sort(extra);
        for(int r : extra){
            if(isLost[r-1]) isLost[r-1] = false;
            else if(isLost[r+1]) isLost[r+1] = false;
        }

        for(int i=1; i<=n; i++){
            if(!isLost[i]) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        체육복 test = new 체육복();
        test.solution(5, new int[]{2,4}, new int[]{1,3,5});
    }
}

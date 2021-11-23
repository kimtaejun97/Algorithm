package programmers.level1;

import java.util.Arrays;

/*
그리디
 */
public class 예산 {
    public int solution(int[] department, int budget) {
        int answer = 0;
        Arrays.sort(department);
        for(int d : department){
            if((budget -= d) >= 0) answer ++;
            else break;
        }
        return answer;
    }
}

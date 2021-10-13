package programmers.광탈방지Java;


import java.util.Arrays;
/*
시뮬레이션
 */
public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int bPointer = 0;
        for(int aNumber : A){
            while(bPointer < B.length && B[bPointer] <= aNumber){
                bPointer++;
            }
            if(bPointer < B.length){
                answer ++;
                bPointer++;
            }
        }

        return answer;
    }
}

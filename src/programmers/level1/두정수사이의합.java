package programmers.level1;

/*
등차 수열의 합
((a + b) * (b - a +1)) /2  (a <=b)
 */
public class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        for(int i=Math.min(a,b); i<= Math.max(a,b); i++){
            answer+= i;
        }
//        int A = Math.min(a,b);
//        int B = Math.max(a,b);
//        return (A+B)*(B-A+1)/2;

        return answer;
    }
}

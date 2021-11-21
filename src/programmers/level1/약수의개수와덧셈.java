package programmers.level1;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++){
            if(isEvenDivisor(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }
    private boolean isEvenDivisor(int num) {
        if(getNumberOfDivisor(num) % 2 == 0) return true;
        return false;
    }

    private int getNumberOfDivisor(int num) {
        int answer = 0;
        for(int i=1; i<=num; i++){
            if(num % i == 0) answer++;
        }
        return answer;
    }
}
/*
다른 풀이:
제곱수 -> 약수의 개수가 홀수
제곱수가 아님 -> 약수의 개수가 짝수.
num % sqrt(num) == 0 이면 제곱수.
 */

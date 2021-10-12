package programmers.Java강의문제;

public class 예산 {
    public int solution(int[] budgets, int M) {
        int answer =0;
        int sum = 0;
        int left = 0;
        int right = 0;
        int mid = 0;

        for(int budget : budgets){
            sum += budget;
            if(budget > right) right = budget;
        }
        if(sum <= M) return right;

        // mid == 상한액
        while(left <= right){
            mid = (left + right) / 2;
            sum = 0;
            for(int budget: budgets){
                if(budget <= mid){
                    sum += budget;
                }else{
                    sum += mid;
                }
            }
            if(sum > M){
                right = mid -1;
            }else{
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }
}

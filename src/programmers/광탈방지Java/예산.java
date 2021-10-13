package programmers.광탈방지Java;

/*
탐색 - 이분탐색
 */
public class 예산 {
    public int solution(int[] budgets, int M) {
        int answer =0;
        int sum = 0;
        int left = 0;
        int right = 0;

        for(int budget : budgets){
            if(budget > right) right = budget;
        }

        // mid == 상한액
        int mid = 0;
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

    public static void main(String[] args) {
        예산 test =  new 예산();
        int solution = test.solution(new int[]{10, 20, 30}, 100);
        System.out.println("solution = " + solution);
    }
}

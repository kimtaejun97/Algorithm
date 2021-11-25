package programmers.level1;

public class 진법뒤집기3 {
    public int solution(int n) {
        int answer = 0;

        // 3진법으로 변환 + 뒤집기
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n % 3);
            n /=3;
        }
        // 10진수로 변환
//        int mul = 1;
//        String[] nums = sb.toString().split("");
//        for(int i= nums.length-1; i>=0; i--){
//            answer += mul * Integer.parseInt(nums[i]);
//            mul *= 3;
//        }

        return Integer.parseInt(sb.toString(), 3);
    }
}

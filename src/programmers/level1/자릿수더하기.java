package programmers.level1;

public class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        // 0.17ms, 77MB
//        String[] nums =  String.valueOf(n).split(" ");
//        for(String num : nums){
//            answer += Integer.parseInt(num);
//        }
        
        // 0.02ms , 87.6 MB
        while(n > 0){
            answer += n % 10;
            n /=10;
        }
        return answer;
    }
}

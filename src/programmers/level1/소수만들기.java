package programmers.level1;

public class 소수만들기 {
    static boolean[] isPrime = new boolean[3001];
    static int answer = 0;
    public int solution(int[] nums) {
        prepare();

        for(int i = 0; i<nums.length -2; i++){
            for(int j = i+1; j<nums.length -1; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(isPrime[nums[i] + nums[j] + nums[k]]) answer ++;
                }
            }
        }

        return answer;
    }

    public void prepare(){
        for(int i=2; i<isPrime.length; i++){
            isPrime[i] = true;
        }
        for(int i=2; i*i<isPrime.length; i++){
            if(isPrime[i]){
                for(int j = i*i; j<isPrime.length; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
}

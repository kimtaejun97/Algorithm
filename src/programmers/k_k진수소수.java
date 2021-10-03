package programmers;


public class k_k진수소수 {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        // k 진수로 변환.
        while(n > 0){
            sb.append(n % k);
            n /= k;
        }
        String kValue = sb.reverse().toString();

        // 숫자 탐색
        kValue = kValue.replaceAll("[0]{1,}", " ").trim();
        String[] numbers = kValue.split(" ");

        // P 탐색
        for(String number : numbers){
            if(isPrime(Long.valueOf(number))){
                answer ++;
            }
        }


        return answer;
    }

    public boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        for(int i =2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        k_k진수소수 test = new k_k진수소수();
        int solution = test.solution(1111010100, 2);
        System.out.println(solution);





    }
}

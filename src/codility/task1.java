package codility;

public class task1 {
    public int solution(int N) {
        StringBuilder sb = new StringBuilder();
        int answer =0;

        // Change to BinaryCode
        while(N > 1){
            sb.append(N%2);
            N /=2;
        }
        sb.append(N);
        sb.reverse();

        // Binary gep
        boolean start = false;
        int count = 0;
        for(char c :sb.toString().toCharArray()){
            if(!start && c=='1') start = true;
            else if(start && c =='0' ) count ++;
            else if(start && c=='1'){
                answer = Math.max(answer, count);
                count =0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        task1 test = new task1();
        int solution = test.solution(328);
        System.out.println("solution = " + solution);
    }
}

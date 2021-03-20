package programmers;
import java.util.Queue;
import java.util.LinkedList;
public class 주식가격 {
    public int[] solution(int[] prices){
        int len = prices.length;
        int[] answer = new int[len];
        int count =0;

        for(int i=0; i<len; i++){
            for(int j =i+1; j<len; j++){
                count++;
                if(prices[j]<prices[i])
                    break;
            }
            answer[i] = count;
            count = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        주식가격 w = new 주식가격();
        int[] p = {1,2,3,2,3};
        p = w.solution(p);
        for(int v :p)
        System.out.println(v);
    }


}

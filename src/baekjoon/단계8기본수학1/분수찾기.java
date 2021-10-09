package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int child;
        int parent;

        int n = 1;
        while(true){
            int prevSum = s(n);
            int start = prevSum+1;
            int end = prevSum + n;
            int move = 0;

            // n 번째 대각선의 범위에 들어가면,
            if(x >= start && x<= end){
                move = x - start;

                //위에서 아래로
                if(n % 2 == 0){
                    System.out.println(String.format("%d/%d", 1+move, n-move));
                }
                // 아래서 위로
                else{
                    System.out.println(String.format("%d/%d", n-move, 1+ move));
                }
                break;
            }
            n++;
        }
    }

    // n 번째 대각선 이전까지의 누적 원소 수.
    private static int s(int n) {
        int sum = 0;
        for(int i=1; i<n; i++){
            sum +=i;
        }
        return sum;
    }
}

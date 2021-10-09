package baekjoon.단계6함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 99;

        // 1~99 까지는 모두 한수.
        if(n <= 99){
            System.out.println(n);
            return;
        }

        for(int i = 100; i<=n; i++){
            if(isHansoo(i)) answer++;
        }
        System.out.println(answer);

    }

    private static boolean isHansoo(int num) {
        char[] splitNum = String.valueOf(num).toCharArray();
        int diff = splitNum[0] - splitNum[1];
        for(int i=1; i<splitNum.length-1; i++){
            int currDiff = splitNum[i] - splitNum[i+1];
            if(diff != currDiff) return false;
        }
        return true;
    }
}

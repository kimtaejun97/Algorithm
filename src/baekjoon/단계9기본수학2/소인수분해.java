package baekjoon.단계9기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소인수분해{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1) return;

        StringBuilder sb = new StringBuilder();

        for(int i= 2; i<=n; i++){
            while(n % i == 0){
                sb.append(i).append("\n");
                n /=i;
            }
            if(n == 1) break;
        }
        System.out.println(sb.toString());

    }

}

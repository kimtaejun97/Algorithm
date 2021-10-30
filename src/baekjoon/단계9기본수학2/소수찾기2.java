package baekjoon.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
n ~ m 까지의 소수의 합, 최솟값 구하기.
 */
public class 소수찾기2 {
    static boolean[] isPrime = new boolean[10001];
    static final int MAX = 10001;
    public static void main(String[] args) throws IOException {
        prepare();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum =0;
        int min = MAX;

        for(int i = m; i<=n; i++){
            if(isPrime[i]){
                sum+=i;
                if(min == MAX) min = i;
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }else{
            System.out.println(String.format("%d\n%d", sum,min));
        }
    }

    private static void prepare() {
        for(int i =2; i<isPrime.length; i++){
            isPrime[i] = true;
        }
        for(int i=2; i*i< isPrime.length; i++){
            if(isPrime[i]){
                for(int j =i*i; j<isPrime.length; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
}

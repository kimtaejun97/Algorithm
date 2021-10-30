package baekjoon.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());



        isPrime = new boolean[n+1];
        prepare();

        for(int i= m; i<=n; i++){
            if(isPrime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());

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

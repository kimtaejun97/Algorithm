package baekjoon.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {
    static boolean[] isPrime = new boolean[1001];

    public static void main(String[] args) throws IOException {

        prepare();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(isPrime[num]) count ++;
        }
        System.out.println(count);
    }

    private static void prepare() {
        for(int i=2; i<isPrime.length; i++){
            isPrime[i] = true;
        }
        for(int i =2; i*i<isPrime.length; i++){
            if(isPrime[i]){
                for(int j=i*i; j< isPrime.length; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
}

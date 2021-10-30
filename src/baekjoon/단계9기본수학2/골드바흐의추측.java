package baekjoon.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 골드바흐의추측{
    static final int MAX = 10000;
    static boolean[] isPrime = new boolean[MAX +1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();
        prepare();

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int num = Integer.parseInt(br.readLine());
            int minDiff = num;
            int first = 0;
            for(int j=2; j<num; j++){
                if(isPrime[j]){
                    if(isPrime[num-j]){
                        int diff = Math.abs(num -j -j);
                        if(diff < minDiff){
                            first = j;
                            minDiff = diff;
                        }
                    }
                }
            }
            sb.append(first).append(" ").append(num-first).append("\n");
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

package baekjoon.단계9기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 골드바흐의추측2{
    static final int MAX = 10000;
    static boolean[] isPrime = new boolean[MAX +1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();
        prepare();

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int num = Integer.parseInt(br.readLine());
            int first = num/2;
            int last = num/2;

            while (first > 1){
                if(isPrime[first] && isPrime[last]){
                    sb.append(first).append(" ").append(last).append("\n");
                    break;
                }
                first --;
                last ++;
            }
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

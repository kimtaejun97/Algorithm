package baekjoon.단계9기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 베르트랑공준 {
    static final int MAX = 123456;
    static boolean[] isPrime = new boolean[MAX*2 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();
        prepare();

        String input;
        while(!(input = br.readLine()).equals("0")){
            int n =Integer.parseInt(input);
            int count =0;

            for(int i =n+1; i<=2*n; i++){
                if(isPrime[i]) count ++;
            }
            sb.append(count).append("\n");
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

package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.lang.System.in;

public class 팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        BigInteger factorial = new BigInteger("1");
        int count = 0;

        for(int i=2; i<=n; i++){
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }
        char[] fact = factorial.toString().toCharArray();
        int p = fact.length-1;

        //362880
        while(fact[p--] == '0'){
            count++;
        }
        System.out.println(count);
    }
}

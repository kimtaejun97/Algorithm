package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 큰수AB합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        BigInteger num = new BigInteger(st.nextToken());
//        BigInteger num2 = new BigInteger(st.nextToken());
//        System.out.println(num.add(num2));

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        StringBuilder sb = new StringBuilder();

        int sum =0;
        int minLength = A.length;
        char[] shortNumber = A;
        char[] longNumber = B;
        if(B.length < A.length){
            minLength = B.length;
            shortNumber = B;
            longNumber = A;
        }
        int count =0;
        for(int i = longNumber.length-1; i>=0; i--){
            if(count < minLength){
                sum += Integer.parseInt(String.valueOf(longNumber[longNumber.length-1 -count]))
                        + Integer.parseInt(String.valueOf(shortNumber[minLength-1 - count]));
                count++;
            }else{
                sum += Integer.parseInt(String.valueOf(longNumber[i]));
            }
            if(sum < 10){
                sb.append(sum);
                sum = 0;
            }else{
                sb.append(sum % 10);
                sum = 1;
            }
        }
        if(sum !=0){
            sb.append(1);
        }

        sb.reverse();
        System.out.println(sb.toString());
    }
}

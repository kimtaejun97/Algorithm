package baekjoon.단계16정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.in;
/*
A = M * a + r1
B = M * b + r2
나눈 나머지가 같다고 가정하면 r1 == r2이므로,
A - B = M(a-b) 즉 M은 A와 B의 공약수.

- A-B의 최대공약수를 구한후 GCD의 약수들을 구하면 A와 B의 약수들.
- A와 B의 GCD(A,B), GCD(A,B) 와 C의 최대 공약수 GCD(GCD(A,B),C)는 A,B,C의 최대 공약수.
 */
public class 검문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        long GCD = 0;

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        for(int i = 1; i<n; i++){
            GCD = gcd(GCD, nums[i] - nums[i-1]);
        }

        List<Long> factor = new ArrayList<>();
        for(long i=2; i<=Math.sqrt(GCD); i++){
            // 제곱근이면 GCD / i == i이므로 중복 방지.
            if(i*i == GCD) factor.add(i);
            else if(GCD % i == 0){
                factor.add(i);
                factor.add(GCD / i);
            }
        }
        Collections.sort(factor);
        for(long f : factor) sb.append(f).append(" ");
        sb.append(GCD);
        System.out.print(sb.toString());
    }

    private static long gcd(long a, long b) {
        if(b <= 0) return a;
        return gcd(b, a % b);
    }
}

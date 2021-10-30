package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
/*
- 0이 n개 있다는 의미 -> 2와 5가 n개의 쌍이 존재한다. (적은쪽에 맞춰짐)
- 2는 5보다 작은 수기 때문에 연속된 수를 곱하다 보면 2의 소인수분해된 수가 더 많을 수 밖에 없다.
- 즉 소인수 분해 했을 때 5의 수에 따른다.
 */
public class 팩토리얼0의개수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while(n >= 5){
            count += n/5;
            n /= 5;
        }
        System.out.print(count);
    }
}

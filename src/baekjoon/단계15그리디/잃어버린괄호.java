package baekjoon.단계15그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
/*
 - 마다 괄호.
 */
public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int answer = 0;

        // -로 나눴을때 가장 앞부분은 양수.
        answer += Arrays.stream(st.nextToken().split("[+]"))
                .mapToInt(s-> Integer.parseInt(s)).sum();

        // 나머지는 음수.
        while(st.hasMoreTokens()){
            answer -= Arrays.stream(st.nextToken().split("[+]"))
                    .mapToInt(s->Integer.parseInt(s)).sum();
        }

        System.out.println(answer);
    }
}

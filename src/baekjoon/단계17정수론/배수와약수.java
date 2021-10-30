package baekjoon.단계17정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 배수와약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        String nums;
        while(!(nums = br.readLine()).equals("0 0")){
            st = new StringTokenizer(nums, " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(second % first == 0) sb.append("factor").append("\n");
            else if(first % second == 0) sb.append("multiple").append("\n");
            else sb.append("neither").append("\n");
        }
        System.out.print(sb.toString());

    }
}

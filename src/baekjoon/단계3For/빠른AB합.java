package baekjoon.단계3For;

import java.io.*;
/*
첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.

출력
각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
 */
public class 빠른AB합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            String[] value = br.readLine().split(" ");
            int sum = Integer.parseInt(value[0]) + Integer.parseInt(value[1]);
            bw.write(String.valueOf(sum));
            bw.write("\n");
        }
        bw.flush();

    }
}

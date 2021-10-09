package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int wNumber = (n-1)/h + 1;
            int hNumber = (n-1) % h + 1;

            sb.append(String.format("%d%02d", hNumber,wNumber)).append("\n");
        }
        System.out.print(sb.toString());
    }
}

package baekjoon.단계15그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n];
        long[] oilPrice = new long[n];

        // i번째 도시로 가는 거리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<n; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }

        // i번째 도시의 기름 가격.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            oilPrice[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = oilPrice[0];
        long answer = oilPrice[0] * distance[1];

        for(int i=2; i<n; i++){
            if(oilPrice[i-1] < minPrice) minPrice = oilPrice[i-1];

            answer += distance[i] * minPrice;
        }

        System.out.println(answer);
    }
}

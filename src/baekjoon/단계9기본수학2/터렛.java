package baekjoon.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;
/*
각 좌표를 중심으로 한 두 원.
동일 : 무수히 많음.
접한다 : 1개
두 점에서 만난다 : 2개.
 */

public class 터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i =0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 두 원이 동일.
            if(x1 == x2 && y1 ==y2 && r1 == r2){
                sb.append(-1).append("\n");
                continue;
            }

            // 중심 거리
            double distanceOfCenter = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

            // 두 원이 외부, 내부에서 접한다.
            if(distanceOfCenter == r1+r2 || distanceOfCenter == Math.abs(r1-r2)) {
                sb.append(1).append("\n");
            }
            // 두 원이 두 점에서 만난다.
            else if(distanceOfCenter > Math.abs(r1-r2) && distanceOfCenter < r1+r2){
                sb.append(2).append("\n");
            }
            // 만나지 않는다.
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}

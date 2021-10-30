package baekjoon.단계15동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class RGB거리 {
    static int N;
    static int[][] house;
    static int[][] price;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));


        N = Integer.parseInt(br.readLine());
        // [house][R, G, B]
        // 0 은 비우는 값.
        house = new int[N][4];
        price = new int[N][4];

        StringTokenizer st;
        // i번째 집을 RGB 색으로 칠할때의 비용.
        for(int i =0; i<house.length; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c =1; c<=3; c++){
                house[i][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 첫번 째 집 비용
        for(int i=1; i<=3; i++){
            price[0][i] = house[0][i];
        }

        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if(depth == N){
            answer = Math.min(price[depth-1][1], Math.min(price[depth-1][2], price[depth-1][3]));
            return;
        }

        price[depth][1] = Math.min(price[depth-1][2], price[depth-1][3]) + house[depth][1];
        price[depth][2] = Math.min(price[depth-1][1], price[depth-1][3]) + house[depth][2];
        price[depth][3] = Math.min(price[depth-1][1], price[depth-1][2]) + house[depth][3];

        dfs(depth +1);
    }
}

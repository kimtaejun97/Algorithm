package codingtest.nhnCommerce2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class p4_블랙홀 {
    static int n,m,g;
    static boolean[][] way;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 행성의 수
        m = Integer.parseInt(st.nextToken()); // 항로의 수
        g = Integer.parseInt(st.nextToken()); // 중력장의 세기
        selected = new int[n+1];

        way = new boolean[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            way[a][b] = true;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int gPlanet = Integer.parseInt(st.nextToken());

        // a -> b 로 가는 경로 탐색
//        aToB(1, start, end);

        // 중력장 계산.

    }
//    static String aToB(int depth, int start, int end){
//        if(way[start][end]){
//            selected[depth] = end;
//        }
//
//        for(int i = 1; i<=n; i++){
//            if(way[start][i]){
//                selected[depth] = start;
//                aToB(depth + 1, start, end);
//            }
//        }
//    }
}

/*
7 12 2
7 2
5 4
6 4
4 3
3 7
1 6
6 7
5 3
6 5
5 7
4 2
4 7
7 6 3

4

13 11 8
6 9
10 12
9 8
11 1
3 11
8 7
7 5
1 2
2 6
5 4
4 13
8 12 3

-1

10 11 7
8 4
1 5
3 10
2 3
9 7
7 2
10 1
2 8
6 3
9 8
4 6
3 7 1

16

 */

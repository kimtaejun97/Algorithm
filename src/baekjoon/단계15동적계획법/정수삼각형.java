package baekjoon.단계14동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int h = Integer.parseInt(br.readLine());
        int[][] triangle = new int[h][];

        StringTokenizer st;
        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine(), " ");
            triangle[i] = new int[i+1];
            for(int j=0; j<i+1; j++) triangle[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=h-1; i>0; i--){
            for(int j = 0; j<triangle[i].length-1; j++){
                triangle[i-1][j] = Math.max(triangle[i][j], triangle[i][j+1])
                        + triangle[i-1][j];
            }
        }
        System.out.println(triangle[0][0]);
    }
}

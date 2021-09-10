package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] points = new int[t][2];
        String[] point;

        for(int i=0; i<t; i++){
            point = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(point[0]);
            points[i][1] = Integer.parseInt(point[1]);
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] c1, int[] c2) {
                if(c1[0] < c2[0]){
                    return -1;
                }
                else if(c1[0] == c2[0]){
                    if(c1[1] <= c2[1]){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    return 1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int[] p : points){
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
        }
        System.out.println(sb.toString());

    }
}

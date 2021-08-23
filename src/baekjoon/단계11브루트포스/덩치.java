package baekjoon.단계11브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int weight = 0;
        int height = 0;
        int num = Integer.parseInt(br.readLine());
        int[][] info = new int[num][3];

        for(int i =0; i<num; i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            weight = Integer.parseInt(stringTokenizer.nextToken());
            height = Integer.parseInt(stringTokenizer.nextToken());
            int rank = 1;

            for(int j = 0; j<i; j++){
                if(info[j][1] > weight && info[j][2] > height){
                    rank ++;
                }
                else if(info[j][1] < weight && info[j][2] < height){
                    info[j][0] ++ ;
                }
            }
            info[i][0] = rank;
            info[i][1] = weight;
            info[i][2] = height;

        }

        for(int i = 0; i< num; i++){
            System.out.print(info[i][0]+ " ");
        }


    }
}

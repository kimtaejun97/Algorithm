package baekjoon.단계5배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은넘겠지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++){
            String[] input = br.readLine().split(" ");
            int studentNum = Integer.parseInt(input[0]);
            int[] score = new int[studentNum];
            int sum = 0;
            int count = 0;

            for(int j =1; j<=studentNum; j++){
                int num = Integer.parseInt(input[j]);
                score[j-1] = num;
                sum += num;
            }
            double avg = (double)sum / studentNum;

            for(int j=0; j<studentNum; j++){
                if(score[j] > avg){
                    count ++;
                }
            }

            double ratio = ((double)count / studentNum) * 100;
            sb.append(String.format("%.3f", ratio)).append("%\n");
        }
        System.out.println(sb.toString());
    }

}

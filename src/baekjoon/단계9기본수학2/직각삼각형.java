package baekjoon.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();

        String input;
        while(!(input = br.readLine()).equals("0 0 0")){
            String[] lengths = input.split(" ");

            // 빗변(가장 긴 변)을 찾음.
            int max = -1;
            int maxIdx = 0;
            for(int i=0; i<3; i++){
                int length =Integer.parseInt(lengths[i]);
                if(length > max){
                    max = length;
                    maxIdx = i;
                }
            }
            // 빗변의 중앙 좌표에서 0,0(직각 부분의 점)까지의 거리.
            double distance =0;
            for(int i=0; i<3; i++){
                if(i != maxIdx){
                    distance += Math.pow(Double.parseDouble(lengths[i])/2,2);
                }
            }
            distance = Math.sqrt(distance);

            // 빗변의 절반의 길이와 빗변 중앙~직각부분점 길이가 같으면 직각삼각형.
            if(distance == Double.parseDouble(lengths[maxIdx])/2){
                sb.append("right").append("\n");
            }else{
                sb.append("wrong").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());

        int numberOfKg5 = goal / 5 ;
        int remainderWeight =(goal % 5);
        if((goal % 5) % 3 == 0){
            System.out.println(numberOfKg5 + remainderWeight / 3);
            return;
        }
        for(int i = numberOfKg5; i>=0; i--){
            remainderWeight = goal - (i * 5);
            if(remainderWeight % 3 == 0){
                System.out.println(i + remainderWeight / 3);
                return;
            }
        }
        System.out.println(-1);
    }
}

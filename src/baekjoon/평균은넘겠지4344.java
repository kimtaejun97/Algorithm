package baekjoon;

import java.util.Scanner;

public class 평균은넘겠지4344 {

    public static void main(String[] args) {
        int caseNum = 0;
        int studentNum = 0;

        Scanner sc = new Scanner(System.in);
        caseNum = sc.nextInt();

        for(int i =0; i<caseNum; i++){
            studentNum = sc.nextInt();
            int score[] = new int[studentNum];
            int sum = 0;
            float average = 0;
            for(int j = 0; j<studentNum; j++){
                score[j] = sc.nextInt();
                sum+=score[j];
            }
            average = (float)sum /studentNum;
            int count = 0;
            for(int j =0; j<studentNum; j++){
                if(score[j] > average)
                    count++;
            }
            System.out.println(String.format("%.3f", ((float)count/studentNum)*100)+"%");


        }
    }

}

package baekjoon.단계5배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int stack = 0;
            int score = 0;
            String quiz = br.readLine();
            for(char result : quiz.toCharArray()){
                if(result == 'O'){
                    score += ++stack;
                }else stack = 0;
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb.toString());

    }
}

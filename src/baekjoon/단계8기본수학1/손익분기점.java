package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 손익분기점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input," ");

        int fixed = Integer.parseInt(stringTokenizer.nextToken());
        int variable = Integer.parseInt(stringTokenizer.nextToken());
        int price = Integer.parseInt(stringTokenizer.nextToken());
        int profit = price - variable;

        if(variable >= price) {
            System.out.println(-1);
        }
        else{
            System.out.println(fixed/profit + 1);
        }

    }
}

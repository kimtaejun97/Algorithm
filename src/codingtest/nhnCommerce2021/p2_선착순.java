package codingtest.nhnCommerce2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class p2_선착순 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        StringTokenizer st;
        for(int i =0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;
            List<String> joined = new ArrayList<>();

            String[] number = br.readLine().split(" ");
            for(int j=0; j<number.length; j++){
                if(!joined.contains(number[j])){
                    joined.add(number[j]);
                    m--;
                }
                if(m == 0){
                    answer = j+1;
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}

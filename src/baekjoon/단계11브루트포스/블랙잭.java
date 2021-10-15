package baekjoon.단계11브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {
    public static void main(String[] args) throws IOException {

        int sum =0;
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int numberOfCard = Integer.parseInt(stringTokenizer.nextToken());
        int m  = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int card[] = new int[numberOfCard];

        for(int i=0; i<numberOfCard; i++){
            card[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = 0; i<numberOfCard-2; i++){
            for(int j = i+1; j<numberOfCard-1; j++){
                for(int k = j+1; k<numberOfCard; k++){
                    sum = card[i] +card[j] + card[k];
                    if(sum <= m){
                        result = sum >result? sum: result;
                    }


                }
            }
        }

        System.out.println(result);


    }
}

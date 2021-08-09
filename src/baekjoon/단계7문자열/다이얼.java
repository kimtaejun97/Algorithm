package baekjoon.단계7문자열;

//   2    3     4    5    6     7     8    9
//  ABC, DEF , GHI, JKL, MNO ,PQRS, TUV ,WXYZ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다이얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int time = 0;

        for(char c : word.toCharArray()){
            int ascii = (int)c;
            if(c < 'P'){
                time += (c - 'A')/3 + 3;
            }
            else if(c < 'T'){
                time += 8;
            }
            else if(c < 'W'){
                time += 9;
            }
            else{
                time += 10;
            }
        }

        System.out.println(time);

    }

}

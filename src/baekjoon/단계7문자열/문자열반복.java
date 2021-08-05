package baekjoon.단계7문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i =0; i<n; i++){
            words[i] = br.readLine();
        }

        for(int i = 0; i<n; i++){

            String[] split = words[i].split(" ");
            int r = Integer.parseInt(split[0]);
            String word = split[1];

            for(int j =0; j<word.length(); j++){
                    result.append(word.substring(j,j+1).repeat(r));
            }
            result.append("\n");
        }
        System.out.println(result);

    }
}

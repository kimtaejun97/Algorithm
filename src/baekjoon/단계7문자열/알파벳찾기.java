package baekjoon.단계7문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String word =br.readLine();

        for(char i='a'; i<='z'; i++){
            result.append(word.indexOf(i)).append(" ");
        }

        System.out.print(result);
    }
}

package baekjoon.단계7문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();


//        var words = input.replaceAll("[ ]{2,}", " ").strip().split(" ");
//        if(words.length ==1 && words[0].equals("")){
//            System.out.println(0);
//        }
//        else{
//            System.out.println(words.length);
//        }
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        System.out.println(stringTokenizer.countTokens());

    }
}

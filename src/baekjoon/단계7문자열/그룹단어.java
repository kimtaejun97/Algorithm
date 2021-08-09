package baekjoon.단계7문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 그룹단어 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        List<Character> appear = new ArrayList<>();
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            char curr = ' ';
            boolean isGroup = true;

            for(char c : br.readLine().toCharArray()){
                if(c == curr)
                    continue;
                else{
                    if(appear.contains(c)){
                        isGroup = false;
                        break;
                    }
                    else{
                        curr = c;
                        appear.add(c);
                    }
                }
            }
            if(isGroup)
                count ++;
            appear.clear();
        }

        System.out.println(count);

    }


}

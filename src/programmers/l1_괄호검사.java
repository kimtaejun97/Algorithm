package programmers;

import java.util.Arrays;

public class l1_괄호검사 {
    public int solution(String input){
        int answer = 0;

        // (, {, [ ,<
        int[] open = new int[4];
        int[] close = new int[4];

        for(char c : input.toCharArray()){

            switch (c){
                // open
                case '(':
                    open[0] ++;
                    break;
                case '{':
                    open[1] ++;
                    break;
                case '[':
                    open[2] ++;
                    break;
                case '<':
                    open[3] ++;
                    break;
                //close
                case ')':
                    open[0] ++;
                    break;
                case '}':
                    open[1] ++;
                    break;
                case ']':
                    open[2] ++;
                    break;
                case '>':
                    open[3] ++;
                    break;
            }
            for(int i=0; i<4; i++){
                if(open[i] !=close[i]){
                    return -1;
                }
            }

            answer = Arrays.stream(open).sum();

        }
        return answer;
    }
}

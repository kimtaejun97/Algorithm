package programmers;
import java.util.ArrayList;
import java.lang.Math;

public class 모의고사_ExhaustiveSearch {
    class Solution {
        public int[] solution(int[] answers) {
            int[] answer;
            ArrayList<Integer> answ = new ArrayList<>();
            int[] a = {1,2,3,4,5};
            int[] b = {2,1,2,3,2,4,2,5};
            int[] c = {3,3,1,1,2,2,4,4,5,5};

            int[] correctCount ={0,0,0};

            for(int i =0; i<answers.length; i++){
                if (a[i%5] ==answers[i])
                    correctCount[0] ++;
                if (b[i%8] == answers[i])
                    correctCount[1] ++;
                if (c[i%10] == answers[i])
                    correctCount[2] ++;
            }
            int maxCount = Math.max(correctCount[0], Math.max(correctCount[1], correctCount[2]));
            if (maxCount == correctCount[0]) {answ.add(1);}
            if (maxCount == correctCount[1]) {answ.add(2);}
            if (maxCount == correctCount[2]) {answ.add(3);}


            answer = new int[answ.size()];
            for(int i =0; i<answ.size(); i++)
                answer[i] = answ.get(i);

            return answer;

        }
    }

}

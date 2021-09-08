package programmers;

import java.util.ArrayList;
import java.util.List;

public class line2_부정행위가능성지수 {
    public int solution(String answerSheet, String[] sheets){
        int answer = 0;

        for(int i=0; i<sheets.length-1; i++){
            String target = sheets[i];

            // 오답인 항목 인덱스 구하기.
            List <Integer> wrongIndex = new ArrayList<>();
            for(int j=0; j<answerSheet.length(); j++){
                if(target.charAt(j) != answerSheet.charAt(j)){
                    wrongIndex.add(j);
                }
            }

            // 다른 답안지와 비교.
            for(int j=i+1; j<sheets.length; j++){
                String other = sheets[j];
                int maxWrongLength = 0;
                int wrongLength = 0;
                int doubt = 0;
                int score = 0;

                // 답안지 하나에서 답 비교
                for(int wrongIdx : wrongIndex){
                    if(target.charAt(wrongIdx) == other.charAt(wrongIdx)){
                        doubt ++;
                        wrongLength ++;
                    }
                    else{
                        if(wrongLength > maxWrongLength){
                            maxWrongLength = wrongLength;
                        }
                        wrongLength = 0;
                    }
                }
                if(wrongLength > maxWrongLength){
                    maxWrongLength = wrongLength;
                }
                score = (int) (doubt + Math.pow(maxWrongLength, 2));
                if(score > answer){
                    answer = score;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        line2_부정행위가능성지수 test = new line2_부정행위가능성지수();
        int solution = test.solution("24551", new String[]{"24553", "24553", "24553", "24553"});
        System.out.println(solution);

    }
}

package programmers;

import java.util.ArrayList;
import java.util.List;

public class 다트게임_1 {
    public int solution(String dartResult) {
        int answer;
        String token ="";

        List<Integer> scores = new ArrayList<>();

        List<String> tokens = new ArrayList<>();

        // Token 분리(점수, SDT, *#)
        for(char target : dartResult.toCharArray()){
            if(target >= '0' && target<='9'){
                token += String.valueOf(target);
            }
            else{
                //점수 추가
                if(!token.equals("")){
                    tokens.add(token);
                    token = "";
                }
                //문자 추가
                tokens.add(String.valueOf(target));
            }
        }

        // 점수 계산
        while(tokens.size() > 0){
            int score = Integer.parseInt(tokens.remove(0));
            String bonus = tokens.remove(0);

            if(bonus.equals("D")){
                score = (int) Math.pow(score, 2);
            }
            if(bonus.equals("T")){
                score = (int) Math.pow(score,3);
            }

            if(tokens.size() > 0){
                if(tokens.get(0).equals("*")){
                    if(scores.size() > 0){
                        int lastIndex = scores.size()-1;
                        Integer prevScore = scores.remove(lastIndex);
                        scores.add(prevScore * 2);
                    }
                    score *=2;
                    tokens.remove(0);

                }
                else if(tokens.get(0).equals("#")){
                    score = -score;
                    tokens.remove(0);
                }

            }
            scores.add(score);
        }

        answer = scores.stream().mapToInt(score -> score).sum();

        return answer;
    }
}

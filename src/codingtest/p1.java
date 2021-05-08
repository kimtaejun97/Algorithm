package codingtest;

import java.util.HashMap;

public class p1 {
    public int solution(String s) {
        String answerStr =s;

        HashMap<String, String> en2num = new HashMap<>(){
            {
                put("zero", "0");
                put("one", "1");
                put("two", "2");
                put("three", "3");
                put("four", "4");
                put("five", "5");
                put("six", "6");
                put("seven", "7");
                put("eight", "8");
                put("nine", "9");
            }
        };

        for(String engNum : en2num.keySet()){
            answerStr = answerStr.replace(engNum, en2num.get(engNum));
        }

        return Integer.parseInt(answerStr);
    }
}

package programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 가짜영수증 {
    public static boolean solution(String amountText) {
        boolean answer = true;
        int count = 0;

        //regex : [0-9,]

        Pattern p = Pattern.compile("[0-9,]");

        Matcher m = p.matcher(amountText);
        if(!m.find())
            return false;

        if(amountText.charAt(0) == '0' && amountText.length()!=1)
            return false;

        if(amountText.indexOf(',') < 0)
            return true;

        if(amountText.charAt(0) ==',')
            return false;


        for(int i =amountText.length()-1; i>=0; i--){
            if(count == 3){
                if(amountText.charAt(i) !=',')
                    return false;
                else{
                    count =0;
                    continue;
                }
            }
            else{
                if(amountText.charAt(i) ==',')
                    return false;
            }
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        boolean solution = 가짜영수증.solution("112,330,000");
        System.out.println(solution);
    }
}

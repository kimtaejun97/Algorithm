package programmers.level1;

import java.util.Vector;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        int count = 0;
        String[] strArr = s.split("");
        for(String str: strArr){
            if(str.equalsIgnoreCase("P")) count++;
            else if(str.equalsIgnoreCase("Y")) count --;
        }
        return count == 0? true:false;

        /*
        s = s.toUpperCase();
        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
         */
    }
}

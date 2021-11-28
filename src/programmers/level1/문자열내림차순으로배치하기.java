package programmers.level1;


import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

    public String solution(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new StringBuilder(new String(str)).reverse().toString();
    }
}

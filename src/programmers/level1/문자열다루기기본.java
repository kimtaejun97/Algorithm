package programmers.level1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
//        if(s.length() != 4 && s.length() != 6) return false;
//        for(char c : s.toCharArray()){
//            if(!Character.isDigit(c)) return false;
//        }
//        return true;

        return s.matches("^[0-9]{4}|{6}$");

    }
}

package programmers.level1;

public class 가운데글자가져오기 {
    public String solution(String s) {
        int length = s.length();
//        if(length % 2 == 0) return s.substring(length/2-1, length/2+1);
//        else return s.substring(length/2,length/2+1);
        return s.substring((length-1)/2 , length/2+1);
    }
}

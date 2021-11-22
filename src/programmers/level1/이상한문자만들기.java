package programmers.level1;

public class 이상한문자만들기 {
    public String solution(String s) {
        String[] words = s.split("");
        StringBuilder sb = new StringBuilder();

        int wordIdx =0;
        for(int i=0; i< words.length; i++){
            String c = words[i];
            if(c.equals(" ")){
                wordIdx = 0;
                sb.append(c);
                continue;
            }
            if(wordIdx % 2 == 0) sb.append(c.toUpperCase());
            else sb.append(c.toLowerCase());
            wordIdx++;
        }
        return sb.toString();
    }
}

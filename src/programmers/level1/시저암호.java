package programmers.level1;

public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        char[] str = s.toCharArray();
        for(char c : str){
            if(c ==' ') sb.append(" ");
            else{
                if(Character.isUpperCase(c)){
                    int buff = (c - 'A' + n) % 26;
                    sb.append((char)(buff + 'A'));
                }else{
                    int buff = (c - 'a' + n) % 26;
                    sb.append((char)(buff + 'a'));
                }
            }
        }

        return sb.toString();
    }
}

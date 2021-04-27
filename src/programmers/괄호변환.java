package programmers;

// u와 v의 분리 -> ->단말 균형잡인 문자열 ->U, 나머지 ->v
//u가 올바른 문자열이면 그대로 두고 v에 대해여 다시 u v 분리.(재귀)
//u가 올바르지 않으면 u에 대하여 맨앞, 맨 뒤의 문자를 제거.
// '('를 붙이고 나머지 괄호 방향을 뒤집어서 붙이고 ')' 븉임. 반환
// 반환값을 모두 이어 붙임.

public class 괄호변환 {
    public String solution(String p) {
        String answer = "";
        if (p == "")
            return answer;
        String u = "";
        String v = "";
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < p.length(); i++) {
            char parenth = p.charAt(i);
            u += parenth;
            if (parenth == '(')
                lCount++;
            else if (parenth == ')')
                rCount++;
            if (lCount == rCount){
                if(i+1 < p.length())
                    v += p.substring(i+1);
                break;
            }
        }

        if(isCorrect(u)){
            u+= solution(v);
            return u;
        }
        else{
            answer +="(";
            answer+= solution(v);
            answer+=")";
            for(int i =1; i<u.length()-1; i++ ){
                if(u.charAt(i) =='(')
                    answer+=")";
                else
                    answer+= "(";
            }
            return answer;
        }

    }

    public boolean isCorrect(String u){
        int openCount =0;
        char parenth ;
        for(int i =0; i<u.length(); i++) {
            parenth = u.charAt(i);
            if(parenth =='(')
                openCount++;
            else{
                if(openCount==0)
                    return false;
                else
                    openCount--;
            }

        }
        return true;

    }
}

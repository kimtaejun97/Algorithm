package programmers;

public class RecommendID {
    public String solution(String new_id){
        String answer=new_id;

        answer = step1(answer);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);

        return answer;
    }
    public String step1(String id){
        return id.toLowerCase();
    }
    public String step2(String id){
        //[] 문자 집단, 알파벳 소문자, 숫자, -,_,.를 제외한 문자 지우기
        return id.replaceAll("[^a-z0-9-_.]","");
    }
    public String step3(String id){
        //.이 두번이상 반복되는 문자열 .으로 대체
       return id.replaceAll("[.]{2,}",".");
    }
    public String step4(String id){
        //문자열의 시작이. 이거나 문자열의 끝이 . 일경우 제거
        return id.replaceAll("^[.]|[.]$","");
    }
    public String step5(String id){
        //빈 문자열일 경우 a추
        if(id.equals(""))
            return "a";
        else
            return id;
    }
    public String step6(String id){
        //문자열 길이가 16이상일 경우 15이후 문자 제거하고 양 끝에 .이오면 제거.
        if (id.length() >15)
            return step4(id.substring(0,15));
        else
            return id;
    }
    public String step7(String id){
        //문자열의 길이가 3보다 작으면 맨 마지막 문자를 길이가 3이될때까지 이어붙이기.
        String new_id = id;
        if(id.length() <3) {
            while (new_id.length() < 3) {
                new_id += id.charAt(id.length() - 1);
            }
        }
        return new_id;
    }

    public static void main(String[] args) {
        String id = "..!@BaT#*..y.abcdefghijklm";
        id = "z-+.^.";
        id = "=.=";
        id= "123_.def";
        id = "abcdefghijklmn.p";


        RecommendID rc = new RecommendID();
        System.out.println(rc.solution(id));
    }
}

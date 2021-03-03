package programmers;

public class StringCompression {
    public int solution(String s){
        int answer =s.length();
        int len = s.length();
        String resultString = "";

        //나눠읽을 문자 수
        for(int split = len /2; split>=1; split--){
            int count =1;
            String word = s.substring(0,split);
            for(int j = split; j<=len-split;){
                String target = s.substring(j,j+split);
                if(word.equals(target)){
                    count++;
                }
                else{
                    //지금까지 반복된 문자열을 저장하고 초기화.
                    if(count >1){
                        resultString += Integer.toString(count) +word;
                    }
                    else{
                        resultString+= word;
                    }
                    word = target;
                    count = 1;

                }
                j+=split;
            }
            if(count >1)
                resultString += Integer.toString(count) + word;
            else
                resultString += word;

            int tail = len%split;
            if (tail!=0){
                resultString += s.substring(len-tail, len);
            }

            answer  = resultString.length() < answer? resultString.length():answer;
            resultString ="";
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabc";
        StringCompression sc = new StringCompression();
        int answer =sc.solution(s);
        System.out.println(answer);
    }
}

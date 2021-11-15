package programmers.level2;
/*
 답을 구하기 까지 구해야 하는 문자열의 길이 = t*m -(m-p) 이상.
1. n진수를 구해가며 문자열에 해당 길이 이상이 될 때 까지 붙인다.
2. 튜브의 차례의 숫자만 골라 답을 만든다.
 */
public class n진수게임 {
    final static String[] convert  = new String[]{
            "0","1","2","3","4","5","6","7","8","9",
            "A","B","C","D","E","F"
    };

    public String solution(int n, int t, int m, int p) {
        StringBuilder gameAllString = new StringBuilder();

        int len = t*m - (m-p);

        StringBuilder convNum;
        gameAllString.append(0);
        int i =1;
        while(gameAllString.toString().length() < len){
//            convNum = new StringBuilder();
//            int num = i;
//            while(num > 0){
//                convNum.append(convert[num % n]);
//                num /= n;
//            }
//            convNum.reverse();
//            gameAllString.append(convNum.toString());
            gameAllString.append(Integer.toString(i,n));
            i++;
        }
        String allString = gameAllString.toString();
        StringBuilder answer = new StringBuilder();
        int pointer = p-1;
        for(int count=0; count<t; count++){
            answer.append(allString.charAt(pointer));
            pointer +=m;
        }

        return answer.toString();
    }

}

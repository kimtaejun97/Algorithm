package programmers;

import java.util.Arrays;

public class 비밀지도_1 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int pointer = 0;

        int[] fullMap = new int[n];

        for(int i=0; i<n; i++){
            fullMap[i] = arr1[i] | arr2[i];
        }

        for(int code : fullMap){
            StringBuilder line = new StringBuilder();

            for(int i =n-1; i >=0; i--){
                int pow = (int)Math.pow(2, i);

                if(code / pow > 0){
                    line.append("#");
                    code -= pow;
                }
                else{
                    line.append(" ");
                }
            }
            answer[pointer++] = line.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        비밀지도_1 test = new 비밀지도_1();
        String[] solution = test.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});

    }

}

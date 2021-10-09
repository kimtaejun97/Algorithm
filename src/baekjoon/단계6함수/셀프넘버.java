package baekjoon.단계6함수;

import java.io.IOException;

public class 셀프넘버 {
    static boolean[] hasConstructor = new boolean[100001];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<=10000; i++){
           int result = d(i);
           if(result <= 10000){
               hasConstructor[result] = true;
           }
        }
        for(int i=1; i<10000; i++){
            if(!hasConstructor[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }


    private static int d(int number) {
        int result = number;
        String num = String.valueOf(number);
        for(char v : num.toCharArray()){
            result += Integer.parseInt(String.valueOf(v));
        }
        return result;
    }
}

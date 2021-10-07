package baekjoon.단계4While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기싸이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;
        if(input.length() == 1){
            input = "0" + input;
        }
        String newNumber = input;


        while(true){
            if(count !=0 && newNumber.equals(input)){
                break;
            }
            int front = Integer.parseInt(newNumber.substring(0,1));
            int back = Integer.parseInt(newNumber.substring(1));
            String sum = String.valueOf(front + back);
            newNumber = back + sum.substring(sum.length()-1);
            count++;
        }

        System.out.println(count);
    }

}

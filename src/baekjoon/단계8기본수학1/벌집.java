package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2-7, 8 - 19, 20-37...
// range : 6( n + (n-1) + (n-2)...) +2 - > 3n(n+1) + 2 ~ 3n(n+1) + 6(n+1) +1
// range : 3n(n+1) +2 ~ 3n(n+3) +7
// n+1 개의 방을 들러야 함.
public class 벌집 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input  = Integer.parseInt(br.readLine());
        int n = 0;

        if(input == 1){
            System.out.println(1);
        }
        else{
            while(true){
                if((input >= 3*n*(n+1) + 2) && input <= 3*n*(n+3) + 7 ){
                    break;
                }
                n++;
            }

            System.out.println(n+2);
        }

        // 또는 초깃값부터 6n 씩 더해가며 이보다 작은지 검사.




    }
}

package baekjoon.단계3FOR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 기찍N {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=n; i>0;i--){
            System.out.println(i);
        }
    }
}

package baekjoon.단계3FOR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++){
            sb.append(" ".repeat(n-i)).append("*".repeat(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}

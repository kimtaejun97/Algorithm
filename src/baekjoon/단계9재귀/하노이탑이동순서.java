package baekjoon.단계9재귀;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import static java.lang.System.in;

public class 하노이탑이동순서 {
    static StringBuilder sb =new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n,1, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int currTower, int destTower) {
        if(n == 1){
            sb.append(currTower + " " + destTower).append("\n");
            count++;
            return;
        }

        int otherTower = 0;
        for(int i=1; i<=3; i++){
            if(i != currTower && i != destTower) otherTower = i;
        }

        hanoi(n-1, currTower, otherTower);
        sb.append(currTower + " " + destTower).append("\n");
        count++;
        hanoi(n-1, otherTower, destTower);
    }
}

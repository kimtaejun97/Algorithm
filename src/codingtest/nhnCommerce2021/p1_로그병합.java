package codingtest.nhnCommerce2021;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

import static java.lang.System.in;

public class p1_로그병합 {
    public static final Scanner scanner = new Scanner(in);

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = scanner.nextInt(); // 송수신 기록의 수
        int logCount = n;

        String log = ""; // 송수신 기록
        String prevLog = scanner.nextLine().trim();
        int sameCount = 1;
        for (int i = 0; i < n; i++) {
            log = scanner.nextLine().trim();
            if(log.equals(prevLog)){
                sameCount ++;
                logCount --;
            }
            else{
                if(sameCount == 1) sb.append(prevLog).append("\n");
                else sb.append(prevLog).append(" (").append(sameCount).append(")\n");

                sameCount = 1;
                prevLog = log;
            }
        }
        if(sameCount > 1) sb.append(prevLog).append(" (").append(sameCount).append(")\n");
        else sb.append(prevLog);

        System.out.println(logCount);
        System.out.print(sb.toString());
    }
}

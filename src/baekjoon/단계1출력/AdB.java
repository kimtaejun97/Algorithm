package baekjoon.단계1출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");
        System.out.println(Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()));
    }
}

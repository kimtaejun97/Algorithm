package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numString = br.readLine();
        char[] chars = numString.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder(new String(chars)).reverse();
        System.out.println(sb.toString());

    }
}

package baekjoon.단계7문자열;

import java.util.Scanner;

public class 아스키코드 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char alphabet = scanner.next().charAt(0);
        System.out.println((int)alphabet);
    }
}

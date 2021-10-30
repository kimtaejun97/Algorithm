package baekjoon.단계10재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 별찍기10 {
    static char[][] starArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb =new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        starArr = new char[n][n];
        printStar(0,0, n);

        for(char[] starRow :starArr){
            for(char starElm : starRow){
                sb.append(starElm);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());


    }

    private static void printStar(int startY, int startX, int n) {
        StringBuilder sb =new StringBuilder();

        if(n == 1){
            starArr[startY][startX] = '*';
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i ==1 && j ==1){
                    space(startY + i*(n/3),startX + j*(n/3) ,n/3);
                }else{
                    printStar(startY + i*(n/3),startX + j*(n/3) ,n/3);
                }
            }
        }
    }
    private static void space(int startY, int startX, int n){
        if(n==1){
            starArr[startY][startX] = ' ';
            return;
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                space(startY + i*(n/3),startX + j*(n/3) ,n/3);
            }
        }

    }
}

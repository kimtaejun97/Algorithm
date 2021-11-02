package baekjoon.단계20분할정복법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
행렬 A의 b 제곱.
 */
public class 행렬제곱 {
    static final int P = 1000;
    static int n;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        A = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                A[i][j] = Integer.parseInt(st.nextToken()) % P;
            }
        }
        int[][] B = pow(b);
        printArr(B);
    }
    private static int[][] pow(long b) {
        if(b == 1) return A;

        int[][] c = pow(b/2);


        if(b % 2 ==0){
            return mul(c, c);
        }
        else{
            return mul(mul(c, c), A);
        }
    }

    private static int[][] mul(int[][] a, int[][] b){
        int[][] c = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    c[i][j] += ((a[i][k] % P) * (b[k][j] % P)) % P;
                }
                c[i][j] %= P;
            }
        }
        return c;
    }

    private static void printArr(int[][] arr){
        StringBuilder sb = new StringBuilder();
        for(int[] row : arr){
            for(int e : row){
                sb.append(e).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
package baekjoon.단계20분할정복법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈 {
    static int[][] newArr;
    static int [][] A, B;
    static int n,m,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        k = Integer.parseInt(st.nextToken());
        B = new int[m][k];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<k; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        newArr = new int[n][k];
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                newArr[i][j] = mul(i,j, 0);
            }
        }

//        for(int i=0; i<n; i++){
//            for(int j=0; j<k; j++){
//                for(int t=0; t<m; t++){
//                    newArr[i][j] += A[i][t] * B[t][j];
//                }
//            }
//        }

        StringBuilder sb = new StringBuilder();
        for(int[] row : newArr){
            for(int elm : row){
                sb.append(elm).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int mul(int aRow, int bCol, int numberOfElm) {
        if(numberOfElm >= m) return 0;
        return A[aRow][numberOfElm] * B[numberOfElm][bCol]
                + mul(aRow,bCol, numberOfElm+1);
    }
}

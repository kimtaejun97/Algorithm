package codingtest.nhnCommerce2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class p3_레이저 {
    static int m, n;
    static int[][] block;
    static int answer = 0;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        block = new int[n+1][m];
        selected = new int[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                block[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, k);
        System.out.println(answer);
    }

    private static void dfs(int depth, int k) {
        if(k <= 0){
            int sum = Arrays.stream(selected).sum();
            answer = Math.max(answer, sum);
            return;
        }
        if(depth == n){
            if(k > m) return;
            selected[depth] = block[depth][m-k];
            dfs(depth+1, 0);
            selected[depth] = 0;
        }
        else{
            for(int i=0; i<=m; i++){
                if(k-i >= 0){
                    if(i == 0 ) selected[depth] = 0;
                    else selected[depth] = block[depth][m-i];
                    dfs(depth + 1,k-i);
                    selected[depth] = 0;
                }
            }
        }
    }
}

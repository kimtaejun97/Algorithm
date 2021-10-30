package baekjoon.단계14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 스타트와링크 {
    static int N;
    static int[][] ability;
    static int answer = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        selected = new boolean[N];

        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        System.out.println(answer);
    }
    private static void dfs(int depth, int start) {
        if(depth > N/2){
            int startTeam = 0;
            int linkTeam = 0;
            for(int i =0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(selected[i] && selected[j]){
                        startTeam += ability[i][j];
                    }
                    else if(!selected[i] && !selected[j]){
                        linkTeam += ability[i][j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(startTeam - linkTeam));
            return;
        }

        for(int i = start; i<N; i++){
            selected[i] = true;
            dfs(depth + 1, i + 1);
            selected[i] = false;

        }
    }
}

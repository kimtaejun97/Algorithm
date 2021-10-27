package baekjoon.단계15그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        // start, end
        int[][] sessions = new int[n][2];
        int answer = 0;

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            sessions[i][0] = Integer.parseInt(st.nextToken());
            sessions[i][1] = Integer.parseInt(st.nextToken());
        }
        /*
            종료 시간만 가지고 할 경우 예외.
            0 1
            2 2
            1 2
         */
        // 회의 종료시간, 시작시간으로 오름차순 정렬
        Arrays.sort(sessions, new Comparator<int[]>() {
            @Override
            public int compare(int[] c1, int[] c2) {

                if(c1[1] == c2[1]) return c1[0] - c2[0];
                return c1[1] - c2[1];
            }
        });

        int endTime = 0;
        for(int i = 0; i<n; i++){
            // 회의의 시작시간이 이전 회의의 종료시간보다 뒤.
            if(sessions[i][0] >= endTime){
                answer++;
                endTime = sessions[i][1];
            }
        }
        System.out.println(answer);
    }
}

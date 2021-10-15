package baekjoon.단계11브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int boardRow = Integer.parseInt(st.nextToken());
        int boardColumn = Integer.parseInt(st.nextToken());
        char[][] board = new char[boardRow][boardColumn];
        for(int i = 0; i<boardRow; i++){
            board[i] = br.readLine().toCharArray();
        }

        int answer = boardRow * boardColumn;

        // 8 x 8 씩 탐색.
        for(int i=0; i+8<=boardRow; i++){
            for(int j = 0; j+8<=boardColumn; j++){
                //변경 횟수 맨위가 검정일때, 맨 위가 흰색일 때.
                int bCount = 0;
                int wCount = 0;

                // 왼쪽 위가 검정
                for(int r=i; r<i+8; r++){
                    for(int c=j; c<j+8; c++){
                        // (r-i) + (c-j) 가 짝수 일 때 검정이면 wCount++, 흰색이면 bCount++
                        if(((r-i) + (c-j)) % 2 == 0){
                            if(board[r][c] == 'B') wCount++;
                            else bCount ++;
                        }
                        // 홀수일때 검정이면 bCount++, 흰색이면 wCount++
                        else if(((r-i) + (c-j)) % 2 != 0){
                            if(board[r][c] == 'B') bCount ++;
                            else wCount ++;
                        }
                    }
                }
                answer = Math.min(answer,Math.min(bCount,wCount));
            }
        }
        System.out.println(answer);
    }
}

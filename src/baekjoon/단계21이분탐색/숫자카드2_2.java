package baekjoon.단계21이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2_2 {
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            // 왼쪽 오른쪽 끝 찾기.
            int leftBound = getLowerBound(num);
            int rightBound = getUpperBound(num);
            sb.append(rightBound - leftBound -1).append(" ");
        }
        System.out.print(sb.toString());
    }

    private static int getLowerBound(int target) {
        int left = 0;
        int right = card.length -1;
        int mid = 0;

        while(left<=right){
            mid = (left + right) / 2;

            // target이 아닐때까지 right을 조임. -> target이 아닌 가장 첫 인덱스.
            if(target > card[mid]) left = mid +1;
            else right = mid -1;
        }
        return right;
    }

    private static int getUpperBound(int target) {
        int left = 0;
        int right = card.length -1;
        int mid = 0;

        while(left<=right){
            mid = (left + right) / 2;

            if(target >= card[mid]) left = mid +1;
            else right = mid -1;
        }
        return left;
    }
}

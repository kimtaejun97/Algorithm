package baekjoon.단계21이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10816
*/
public class 숫자카드2 {
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
            int count = bsCount(Integer.parseInt(st.nextToken()));
            sb.append(count).append(" ");
        }
        System.out.print(sb.toString());
    }

    private static int bsCount(int target) {
        int left = 0;
        int right = card.length -1;

        while(left<=right){
            int mid = (left + right) / 2;

            if(target == card[mid]){
                // 왼쪽 탐색 왼쪽 끝 찾기.
                int leftBound = findLeftBound(left, mid-1, target);
                // 오른쪽 탐색, 오른쪽 끝 찾기.
                int rightBound = findRightBound(mid+1, right, target);

                return rightBound - leftBound -1;
            }
            else if(target < card[mid]) right = mid-1;
            else left = mid + 1;
        }
        return 0;
    }

    private static int findLeftBound(int left, int right, int target) {
        int mid = -1;

        while(left<=right){
            mid = (left + right) / 2;
            if(target == card[mid]){
                if(mid == right) return right -1;
                // 아직 targer과 같다면 재귀로 더 오른쪽 탐색.
                return findLeftBound(left, mid-1, target);
            }
            else if(target < card[mid]) right = mid-1;
            else left = mid + 1;
        }
        return right;
    }

    private static int findRightBound(int left, int right, int target) {
        int mid = -1;

        while(left<=right){
            mid = (left + right) / 2;
            if(target == card[mid]){
                if(mid == right) return left + 1 ;
                return findRightBound(mid+1, right, target);
            }
            else if(target < card[mid]) right = mid-1;
            else left = mid + 1;
        }
        return left;
    }
}

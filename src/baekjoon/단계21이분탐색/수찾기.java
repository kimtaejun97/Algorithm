package baekjoon.단계21이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1920
public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            int flag = binarySearch(A, Integer.parseInt(st.nextToken()));
            sb.append(flag).append("\n");
        }
        System.out.print(sb.toString());

    }

    private static int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length-1;

        while(left<= right){
            int mid = (left + right) /2;

            if(a[mid] == target) return 1;
            else if(target < a[mid]) right = mid - 1;
            else if(target > a[mid]) left = mid + 1 ;
        }
        return 0;
    }
}

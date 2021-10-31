package baekjoon.단계19큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");;
            int n = Integer.parseInt(st.nextToken());
            int waitingNumber = Integer.parseInt(st.nextToken());
            int[] waitingQueue = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                waitingQueue[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(testCase(n, waitingNumber, waitingQueue)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int testCase(int n, int waitingNumber, int[] waitingQueue) {
        Queue<Integer> q = new LinkedList();
        for(int doc : waitingQueue) q.add(doc);
        int count = 0;

        while(true){
            int target = q.poll();
            boolean isPrinted = true;
            for(Iterator it = q.iterator(); it.hasNext();){
                if((int)it.next() > target){
                    isPrinted = false;
                    q.add(target);
                    break;
                }
            }
            if(isPrinted) count++;
            if(waitingNumber == 0){
                if(isPrinted) return count;
                else waitingNumber = q.size()-1;
            }else{
                waitingNumber --;
            }
        }
    }
}

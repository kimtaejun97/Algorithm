package baekjoon.단계19큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class 회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        int[] targets = new int[m];
        for(int i=0; i<m; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque();
        for(int i=1; i<=n; i++){
            deque.offer(i);
        }

        for(int target : targets){
            int idx = 1;
            Iterator it = deque.iterator();
            while(it.hasNext()){
                if((int)it.next() == target){
                    // 왼쪽으로 회전
                    if(idx <= deque.size() - idx +1){
                        while(idx > 1){
                            deque.offerLast(deque.pollFirst());
                            answer++;
                            idx--;
                        }
                        deque.pollFirst();
                        break;
                    }
                    // 오른쪽으로 회전.
                    else{
                        idx = deque.size() - idx + 1;
                        while(idx > 0){
                            deque.offerFirst(deque.pollLast());
                            answer++;
                            idx --;
                        }
                        deque.pollFirst();
                        break;
                    }
                }
                else idx ++;
            }
        }
        System.out.print(answer);

    }
}

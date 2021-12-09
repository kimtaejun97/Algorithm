package codility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
연속된 R개의 선반을 사용 불가로 지정할 때
사용 유형을 가장 많이 남기는.
 */
public class p2 {
    public int solution(int[] A, int R) {
        int answer = 0;
        int[] types = new int[100001];
        Set<Integer> typeSet = new HashSet<>();

        for(int a : A) {
            types[a] ++;
            typeSet.add(a);
        }

        for(int i=0; i<=A.length-R; i++){
            int numberOftype = typeSet.size();

            //window
            Map<Integer, Integer> windowNum = new HashMap<>();
            for(int j=i; j<i+R; j++){
                windowNum.put(A[j], windowNum.getOrDefault(A[j], 0)+1);
            }

            for(Map.Entry<Integer,Integer> entry : windowNum.entrySet()){
                if(types[entry.getKey()] - entry.getValue() <=0) numberOftype --;
            }
            answer = Math.max(answer, numberOftype);
        }
        return answer;
    }
}

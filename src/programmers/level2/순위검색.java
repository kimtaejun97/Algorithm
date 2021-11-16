package programmers.level2;

import java.util.*;

public class 순위검색 {
    static Map<String, List<Integer>> queryTable = new HashMap<>();
    static String[] selected = new String[5];

    public int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        int p = 0;


        for(String i: info){
            String[] infoTokens = i.split(" ");
            // 모든 경우의 query 를 생성.
            makeQueryKey(1, infoTokens);
        }

        // 점수 정렬 - 점수 배열을 여러번 탐색할 것이기 때문에 이분탐색 사용을 위해.
        for(List<Integer> scores: queryTable.values()){
            if(scores != null) Collections.sort(scores);
        }


        for(String q: queries){
            // 쿼리 , 점수
            String[] query = q.replace(" and ", "")
                    .split(" ");
            int queryScore = Integer.parseInt(query[1]);
            List<Integer> scores = queryTable.get(query[0]);

            if(scores == null){
                answer[p++] = 0;
            }
            else{
                answer[p++] = getCountGTQueryScore(scores,queryScore);
            }
        }
        return answer;
    }

    private int getCountGTQueryScore(List<Integer> scores, int queryScore) {
        int left = 0;
        int right = scores.size()-1;
        int mid;

        // lower bound 를 찾음.(right)
        while(left <= right){
            mid = (left + right) / 2;

            if(queryScore > scores.get(mid) ) left = mid +1;
            else right = mid -1;
        }

        return scores.size() - right -1;
    }

    private void makeQueryKey(int depth, String[] infoTokens) {
        if(depth >=5){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<selected.length; i++){
                sb.append(selected[i]);
            }
            String queryKey = sb.toString();
            queryTable.put(queryKey, queryTable.getOrDefault(queryKey, new ArrayList<>()));
            // 쿼리키에 점수 추가.
            queryTable.get(queryKey).add(Integer.valueOf(infoTokens[4]));
            return;
        }
        // 해당 조건이 -일 때.
        selected[depth] = "-";
        makeQueryKey(depth+1, infoTokens);
        // 조건이 있을 때.
        selected[depth] = infoTokens[depth-1];
        makeQueryKey(depth+1, infoTokens);
    }
}


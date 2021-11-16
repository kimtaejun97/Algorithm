package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

/*
- 각 orders[i] 에서 코스의 길이만큼의 조합을 탐색. map에 추가, 다른 order에서 같은 조합이 나오면 value ++;
조합: course 의 길이가 최대 깊이가 됨.
각 길이 별로 가장 많이 주문한 메뉴구성 출력.
 */
public class 메뉴리뉴얼 {
    Map<String, Integer> course = new HashMap<>();
    char[] selected = new char[21];
    static int length = 0;

    public String[] solution(String[] orders, int[] courseLength) {
        String[] answer;
        int p = 0;
        int[] maxCount = new int[11];

        for(int l : courseLength){
            for(String o : orders){
                char[] order = o.toCharArray();
                Arrays.sort(order);
                length = l;
                combination(1, order, 0);
            }
        }
        // 사전순 정렬 및 2보다 작은 주문 수 거르기.
        List<Map.Entry<String, Integer>> sortedCourse = course.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(e -> e.getValue() >= 2)
                .collect(Collectors.toList());

        // 각 코스 길이별 최다 주문 횟수 구하기.
        for(Map.Entry<String,Integer> e: sortedCourse){
            int length = e.getKey().length();
            maxCount[length] = Math.max(maxCount[length], e.getValue());
        }

        // 최다 주문과 같은 주문수만 출력.
        List<String> menuList = new ArrayList<>();
        for(Map.Entry<String,Integer> e: sortedCourse){
            String menu = e.getKey();
            if(e.getValue() == maxCount[menu.length()]) menuList.add(menu);
        }
        answer = menuList.toArray(new String[menuList.size()]);
        return answer;
    }

    private void combination(int depth, char[] order, int minIdx) {
        if(depth > length){
            // 생성된 메뉴 조합 추가.
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=length; i++){
                sb.append(selected[i]);
            }
            String menu = sb.toString();
            course.put(menu, course.getOrDefault(menu, 0)+1);
            return;
        }

        for(int i = minIdx; i<order.length; i++){
            selected[depth] = order[i];
            combination(depth+1, order, i+1);
        }
    }
}

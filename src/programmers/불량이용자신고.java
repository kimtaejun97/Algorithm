package programmers;

import java.util.*;
import java.util.stream.Collectors;

// 불량이용자 신고
public class 불량이용자신고 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int p = 0;
        Map<String, Integer> reportCount = new HashMap<>();
        Set<String> uniqueReports = Arrays.stream(report).collect(Collectors.toSet());
        Set<String> stopUser = new HashSet<>();

        // <유저, 유저가 신고한 사람>
        Map<String, List<String>> myReport = new LinkedHashMap<>();
        for(String user: id_list){
            myReport.put(user, new ArrayList<>());
        }

        // 신고한 유저 추가.
        for(String r: uniqueReports){
            String[] split = r.split(" ");

            String user = split[0];
            String target = split[1];

            List<String> rep = myReport.get(user);
            rep.add(target);
            myReport.put(user, rep);

            // 신고 횟수 추가.
            if(reportCount.containsKey(target)){
                int count = reportCount.get(target) + 1;
                if(count >= k){
                    stopUser.add(target);
                    continue;
                }
                reportCount.put(target, count);
            }
            else{
                reportCount.put(target, 1);
            }
        }

        // k번 이상 정지당한 유저.
        for(String user :  reportCount.keySet()){
            if(reportCount.get(user) >= k){
                stopUser.add(user);
            }
        }

        for(String user : myReport.keySet()){
            List<String> reports = myReport.get(user);
            for(String su : stopUser){
                if(reports.contains(su)){
                    answer[p] ++;
                }
            }
            p++;
        }

        return answer;
    }

    public static void main(String[] args) {
        불량이용자신고 test = new 불량이용자신고();
        test.solution(new String[] {"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);

    }
}

package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class l4_계좌데이터복구 {
    public String[][] solution(String[][] snapshots, String[][] transactions){
        String[][] answer ={};
        Map<String,Integer> acccounts = new HashMap<>();
        boolean[] isChecked = new boolean[100001];

        // snapshot account 정보 map에 넣기.
        for(int i = 0; i<snapshots.length; i++){
            for(int j =0; j<snapshots[0].length; j++){
                acccounts.put(snapshots[i][0], Integer.valueOf(snapshots[i][1]));
            }
        }

        // transactions 적용
        for(String[] transaction : transactions){
            int id = Integer.parseInt(transaction[0]);
            if(isChecked[id]){
                continue;
            }
            isChecked[id] =true;
            if(transaction[1].equals("SAVE")){
                acccounts.put(transaction[2],
                        acccounts.getOrDefault(transaction[2], 0) + Integer.parseInt(transaction[3]));
            }
            else{
                acccounts.put(transaction[2],
                        acccounts.get(transaction[2]) - Integer.parseInt(transaction[3]));
            }
        }

        // map 정렬
        List<Map.Entry<String, Integer>> sorted = acccounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        answer = new String[acccounts.size()][2];
        for(int i = 0; i<sorted.size(); i++){
            answer[i][0] = sorted.get(i).getKey();
            answer[i][1] = String.valueOf(sorted.get(i).getValue());
        }

        return answer;

    }

    public static void main(String[] args) {
        l4_계좌데이터복구 test = new l4_계좌데이터복구();
        String[][] solution = test.solution(new String[][]{{"ACCOUNT1", "100"},
                        {"ACCOUNT2", "150"}},
                new String[][]{
                        {"1", "SAVE", "ACCOUNT2", "100"},
                        {"2", "WITHDRAW", "ACCOUNT1", "50"},
                        {"1", "SAVE", "ACCOUNT2", "100"},
                        {"4", "SAVE", "ACCOUNT3", "500"},
                        {"3", "WITHDRAW", "ACCOUNT2", "30"}
                });

        for(String[] s : solution){
            for(String elm : s){
                System.out.print(elm + " ");
            }
            System.out.println();
        }

    }
}

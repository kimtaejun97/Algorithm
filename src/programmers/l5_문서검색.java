package programmers;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class l5_문서검색 {
    public String[] solution(String[][] dataSource, String[] tags){
        String[] answer = {};
        Map<String,Integer> sameDoc = new HashMap<>();

        // 태그 동일 검사.
        for(String[] doc : dataSource){
            int count =0;
            String docName = doc[0];

            for(int i =1; i<doc.length; i++){
                for(String tag : tags){
                    if(doc[i].equals(tag)){
                        count++;
                    }
                }
            }
            if(count > 0){
                sameDoc.put(docName, count);
            }
        }

        // 맵 정렬 일치된 수가 많은 순서.
        List<Map.Entry<String, Integer>> sortedDocs = sameDoc.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> c1, Map.Entry<String, Integer> c2) {
                        if(c1.getValue() > c2.getValue()){
                            return -1;
                        }
                        else if(c1.getValue() == c2.getValue()){
                            if(c1.getKey().compareTo(c2.getKey()) < 0){
                                return -1;
                            }
                            else{
                                return 1;
                            }
                        }
                        else{
                            return 1;
                        }
                    }
                })
                .collect(Collectors.toList());

        if(sortedDocs.size() >= 10){
            answer = new String[10];
        }
        else{
            answer = new String[sortedDocs.size()];
        }

        int count = 0;
        for(int i = 0; i<answer.length; i++){
            answer[i] = sortedDocs.get(i).getKey();
        }

        return answer;
    }

    public static void main(String[] args) {
        l5_문서검색 test = new l5_문서검색();
        String[] solution = test.solution(new String[][]{
                        {"doc1", "t1", "t2", "t3"},
                        {"doc2", "t0", "t2", "t3"},
                        {"doc3", "t1", "t6", "t7"},
                        {"doc4", "t1", "t2", "t4", "t3"},
                        {"doc5", "t6", "t100", "t8"},
                        {"doc6", "t6", "t1", "t8"},
                        {"doc7", "t6", "t1", "t8"},
                        {"doc8", "t6", "t1", "t8"},
                        {"doc9", "t6", "t1", "t8"},
                        {"doc10", "t6", "t1", "t8"},
                        {"doc11", "t6", "t1", "t8"},
                        {"doc12", "t6", "t1", "t8"},
                        {"doc13", "t6", "t1", "t8"},
                        {"doc14", "t6", "t1", "t8"},
                        {"doc15", "t6", "t1", "t8"},
                        {"doc16", "t6", "t1", "t8"}
                },
                new String[]{"t1", "t2", "t3"});

        for(String s : solution){
            System.out.print(s +" ");
        }
    }
}

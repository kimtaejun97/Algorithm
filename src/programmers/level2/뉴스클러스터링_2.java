package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class 뉴스클러스터링_2 {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> setA = new ArrayList<>();
        List<String> setB = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        // 다시 풀기 setA, setB 모두 리스트로 생성

        // A 다중 집합 생성.
        for(int i=0; i< str1.length()-1; i++){
                String elm = str1.substring(i,i+2);
                if(isAlphabet(elm)){
                    setA.add(elm);
            }
        }
        //B 다중 집합 생성
        for(int i=0; i< str2.length()-1; i++){
            String elm = str2.substring(i, i+2);
            if(isAlphabet(elm)){
                setB.add(elm);
            }

        }

        if(setA.size() ==0 && setB.size() == 0){
            return 65536;
        }

        // 합집합 max, 한쪽이라도 존재하면 추가.
        List<String> copyA = new ArrayList<>();
        copyA.addAll(setA);
        List<String> copyB = new ArrayList<>();
        copyB.addAll(setB);

        // A 추가
        while(copyA.size() > 0){
            String target = copyA.get(0);
            if(copyB.contains(target)){
                copyB.remove(target);
            }
            copyA.remove(target);
            union.add(target);
        }
        // B 나머지 추가
        union.addAll(copyB);

        // 교집합 min, 한쪽이라도 존재하지 않으면 추가하지 않음.
        while(setA.size() > 0){
            String target = setA.get(0);
            if(setB.contains(target)){
                intersection.add(target);
                setB.remove(target);
            }
            setA.remove(target);
        }

        double jaccard = (double)intersection.size() / union.size();
        answer = (int)(jaccard * 65536);

        return answer;
    }

    private boolean isAlphabet(String elm) {
        boolean regex = Pattern.matches("^[A-Z]*$", elm);
        if(regex){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        뉴스클러스터링_2 test = new 뉴스클러스터링_2();
        int solution = test.solution("handshake", "shake hands");
        System.out.println(solution);
    }

}

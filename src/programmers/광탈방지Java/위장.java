package programmers.광탈방지Java;

import java.util.HashMap;
import java.util.Map;

/*
해시 (Hash)
 */
public class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> numberOfClothes = new HashMap<>();
        int answer =1;

        // 종류당 의상의 수 구하기.
        for(String[] clth : clothes){
            numberOfClothes.put(clth[1], numberOfClothes.getOrDefault(clth[1], 0)+1);
        }

        // 의상이 선택되는 경우의 수(num), 선택 되지 않는 경우(1)
        for(int num : numberOfClothes.values()){
            answer *= num+1;
        }

        // 모두 선택하지 않는경우를 제외.
        return answer -1;
    }
}

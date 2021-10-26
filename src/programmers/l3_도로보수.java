package programmers;

import java.util.ArrayList;
import java.util.List;

public class l3_도로보수 {
    public int solution(String road, int n){
        int answer = 0;
        List<Integer> zeroIndex = new ArrayList<>();
        char[] roadCharArr = road.toCharArray();

        // 손상된 도로 인덱스 리스트 생성.
        for(int i =0; i<roadCharArr.length; i++){
            if(roadCharArr[i] == '0'){
                zeroIndex.add(i);
            }
        }

        answer = pick(road, zeroIndex, n);


        return answer;
    }
    // 재귀, 재귀 하나당 남은 리스트에서 하나씩 순서대로 선택.
    public int pick(String road,List<Integer> zeroIndex, int n){

        if(zeroIndex.size() == 0){
            return getRoadLength(road);
        }

        int maxLength = 0;
        StringBuffer stringBuffer;
        List<Integer> myZeroIndex = new ArrayList<>();

        // idex List 복사
        myZeroIndex.addAll(zeroIndex);
        for(int i=0; i<myZeroIndex.size(); i++){
            myZeroIndex.clear();
            myZeroIndex.addAll(zeroIndex);
            stringBuffer = new StringBuffer(road);

            int idx = myZeroIndex.remove(i);
            int length = 0;

            // 도로 한 곳 보수
            StringBuffer newRoad = stringBuffer.replace(idx, idx+1, "1");

            // 재귀로 보수된 도로 받아오기
            if(n > 1){
                length = pick(newRoad.toString(), myZeroIndex, n-1);
            }
            else{
                length = getRoadLength(newRoad.toString());
            }
            if(length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }

    // 정상 도로의 최대 길이를 구하여 반환.
    public int getRoadLength(String road){
        int maxLength = 0;
        int length = 0;

        for(char c : road.toCharArray()){
            if(c == '1'){
                length ++;
            }
            else{
                if(length > maxLength){
                    maxLength = length;
                }
                length = 0;
            }
        }
        if(length > maxLength){
            maxLength = length;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        l3_도로보수 test = new l3_도로보수();
        int solution = test.solution("111011110011111011111100011111", 3);
        System.out.println(solution);
    }


}

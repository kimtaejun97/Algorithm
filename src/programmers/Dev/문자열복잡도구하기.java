package programmers.Dev;

import java.util.*;

/*
키보드의 문자위치를 기반으로
문자열의 복잡도 구하기
복잡도 : 문자 사이의 거리.
즉, 좌표값의 절대값 차이.

주어진 문자열의 모든 부분집합의 복잡도의 합을 구하라.
 */
public class 문자열복잡도구하기 {
    static final int MOD = 1000000007;
    static List<String> subString = new ArrayList<>();
    static String str;

    public int solution(String s) {
        int answer = 0;
        Map<Character, int[]> keyboard = new HashMap<>();
        str = s;

        char[] keys = "qwertyuiopasdfghjklzxcvbnm ".toCharArray();
        int p = 0;

        for(int i=0; i< 3; i++){
            for(int j=0; j<9; j++){
                keyboard.put(keys[p++], new int[]{i,j});
            }
        }

        // 길이 2의 부분 문자열 구하기
        createSubString();

        for(int i=0; i<subString.size(); i++){
            char[] str = subString.get(i).toCharArray();
            int[] first = keyboard.get(str[0]);
            int[] second = keyboard.get(str[1]);

            int complexity = Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
            int complexityAllSubString = complexity * (s.length() - 1);
            if(!(i == 0 || i == subString.size()-1)) complexityAllSubString += complexity;

            answer +=  complexityAllSubString;
            answer %= MOD;
        }
        return answer % MOD;
    }

    private void createSubString() {
        for(int i=0; i<=str.length() - 2; i++){
            subString.add(str.substring(i, i+2));
        }
    }

    public static void main(String[] args) {
        문자열복잡도구하기 test = new 문자열복잡도구하기();
        int abcc = test.solution("tooth");
        System.out.println("abcc = " + abcc);
    }
}

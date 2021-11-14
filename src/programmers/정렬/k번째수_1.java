package programmers.정렬;

import java.util.Arrays;

public class k번째수_1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerPointer = 0;

        for(int[] cmd : commands){
            int[] partArr = Arrays.copyOfRange(array, cmd[0]-1, cmd[1]);
            Arrays.sort(partArr);
            answer[answerPointer++] = partArr[cmd[2]-1];
        }

        return answer;
    }
}

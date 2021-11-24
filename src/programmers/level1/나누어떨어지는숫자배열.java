package programmers.level1;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int[] filter = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        if(filter.length > 0) return filter;
        return new int[]{-1};
    }
}

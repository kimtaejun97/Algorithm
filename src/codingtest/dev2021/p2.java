package codingtest.dev2021;

import java.util.Arrays;

/*
휴가의 최대 일 수.
쉬는 날 : 공휴일, 토, 일 + 연차.
휴가를 쓸 수 있는 날 1~30일

- 휴가를 쓸 수 있는 날을 배열로 생성.( 이미 쉬는날 마킹 - true)
- 해당 배열을 재귀를 이용하여 완전 탐색.
- 가장 많은 휴가일 수를 반환.

- 쉬는 날을 구하는 메서드
- true의 수.
 */
public class p2 {
    static String[] weeks = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    static int SAT = 5;
    static int LEAVE =0;
    int answer = 0;
    public int solution(int leave, String day, int[] holidays) {
        boolean[] calendar = new boolean[31];

        LEAVE = leave;

        // 공휴일
        for(int holiday : holidays){
            calendar[holiday] = true;
        }
        // 주말
        int gap = 0;
        for(int i=0; i<weeks.length; i++){
            if(day.equals(weeks[i]))  gap = SAT - i;
        }
        for(int i = 1 + gap; i<30; i+=7){
            calendar[i] = true;
            calendar[i+1] = true;
        }

        dfs(1, calendar);
        return answer;
    }

    private void dfs(int depth, boolean[] calendar) {
        if(depth > LEAVE){
            getLeave(calendar);
            return;
        }
        for(int i=1; i<calendar.length; i++){
            boolean[] nextCalendar = Arrays.copyOf(calendar,calendar.length);
            if(!nextCalendar[i]){
                nextCalendar[i] = true;
                dfs(depth+1, nextCalendar);
            }
        }
    }

    private void getLeave(boolean[] calendar) {
        int count = 0;
        for(boolean leave : calendar){
            if(leave){
                count++;
            }else{
                answer = Math.max(answer, count);
                count =0;
            }
        }
        answer = Math.max(answer, count);
    }

    public static void main(String[] args) {
        p2 test = new p2();
        int fri = test.solution(4, "FRI", new int[]{6, 21, 23, 27, 28});
        System.out.println("fri = " + fri);
    }
}

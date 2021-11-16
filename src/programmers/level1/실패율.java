package programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
n 스테이지의 실패율: n스테이지를 도전중인 유저 / n 스테이지 이상의 유저
challenger[] : 각 스테이지에 도전중인 유저 수
결과: map+sort | node + 우선순위 큐
 */
public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] challenger = new int[N+2];
        int numberOfUser = stages.length;
        PriorityQueue<Stage> q = new PriorityQueue();

        for(int s: stages){
            challenger[s] ++;
        }

        int prev = 0;
        for(int i=1; i<=N; i++){
            // 현재 스테이지에 머문 인원/ 현재 스테이지 이상인 인원
            double failure;
            if((numberOfUser - prev) <=0) failure = 0;
            else failure = (double)challenger[i] /(numberOfUser - prev);

            q.add(new Stage(i, failure));
            prev += challenger[i];
        }

        int p =0;
        while(!q.isEmpty()){
            answer[p++] = q.poll().stage;
        }
        return answer;
    }
}

class Stage implements Comparable<Stage>{
    double failure;
    int stage;

    public Stage(int stage, double failure){
        this.stage = stage;
        this.failure = failure;
    }

    @Override
    public int compareTo(Stage target) {
        // 실패율이 같다면 스테이지를 기준으로 오름차순.
        if(this.failure == target.failure) return this.stage - target.stage;
        // 실패율 기준 내림차순
        else{
            if(this.failure > target.failure) return -1;
            else return 1;
        }
    }

    public static void main(String[] args) {
        실패율 test = new 실패율();
        int[] solution = test.solution(4, new int[]{4,5,3,3});
        System.out.println("test = " + Arrays.toString(solution));
    }
}

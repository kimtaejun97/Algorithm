package codingtest;

public class p1 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int count =0;

        for(int mynum :lottos){
            if(mynum == 0 )
                count++;
            else{
                for(int num : win_nums){
                    if(mynum ==num) {
                        answer[0]++;
                        answer[1]++;
                        break;
                    }

                }
            }
        }
        answer[0] += count;
        if(answer[0] <2)
            answer[0] =6;
        else
            answer[0] = 7-answer[0];

        if(answer[1] <2)
            answer[1] =6;
        else
            answer[1] = 7-answer[1];
        return answer;
    }
}

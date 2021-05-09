package codingtest;


import java.util.ArrayList;
import java.util.Collections;

public class p2 {
    public int[] solution(int[] t, int[] r) {
        int[] answer = new int[r.length];
        int count = 0;

        //time , id
        ArrayList<Integer> arrive = new ArrayList<>();
        ArrayList<Integer> equalRank = new ArrayList<>();
        ArrayList<Integer> equalRT = new ArrayList<>();

        for (int l = 0; l <= 10000; l++) {
            for (int i = 0; i < t.length; i++) {
                if (t[i] != -1 && t[i] <= l)
                    arrive.add(i);
            }
            if (arrive.size() == 1) {
                answer[count++] = arrive.get(0);
                t[arrive.remove(0)] = -1;
            }
            else if (arrive.size() == 0) ;
            //도착한 사람이 여러
            else {
                for (int targetRank = 0; targetRank <=5; targetRank++) {
                    for (int eqindex : arrive) {
                        if (r[eqindex] == targetRank)
                            equalRank.add(eqindex);
                    }
                    if (equalRank.size() == 1) {
                        answer[count++] = equalRank.get(0);
                        t[equalRank.remove(0)] = -1;
                        break;

                    }
                    else if (equalRank.size() == 0) ;
                    //같은 랭크의 사람이 여러명, 먼저 도착한 사람 태움.
                    else {
                        Collections.sort(equalRank);
                        int min =10001;
                        for(int eqi : equalRank){
                            if(t[eqi] <min){
                                min = t[eqi];
                                equalRT.clear();
                                equalRT.add(eqi);
                            }
                            if(t[eqi] == min){
                                equalRT.add(eqi);
                            }
                        }
                        if(equalRT.size() ==1) {
                            answer[count++] = equalRT.get(0);
                            t[equalRT.remove(0)] = -1;
                            equalRank.clear();
                            break;
                        }
                        else {
                            Collections.sort(equalRT);
                            answer[count++] = equalRT.get(0);
                            t[equalRT.get(0)] = -1;
                            equalRT.clear();
                            equalRank.clear();
                            break;
                        }

                    }
                }

            }
            arrive.clear();
            if(count-1 ==t.length)
                break;

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] t ={0,0,1,3,0};
        int[] r ={0,0,1,2,3};

        p2 p = new p2();
        int[]answer =  p.solution(t,r);

        for(int i :answer)
            System.out.println(i);

    }
}

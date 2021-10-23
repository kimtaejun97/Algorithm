package programmers.level1;

import java.util.HashMap;
import static java.lang.Math.abs;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        HashMap<Integer, int[]> leftNumber = new HashMap<>(){
            {
                put(1, new int[]{0, 0});
                put(4, new int[]{1, 0});
                put(7, new int[]{2, 0});
            }
        };
        HashMap<Integer, int[]> centerNumber = new HashMap<>(){
            {
                put(2, new int[]{0, 1});
                put(5, new int[]{1, 1});
                put(8, new int[]{2, 1});
                put(0, new int[]{3, 1});
            }
        };
        HashMap<Integer, int[]> rightNumber = new HashMap<>(){
            {
                put(3, new int[]{0, 2});
                put(6, new int[]{1, 2});
                put(9, new int[]{2, 2});
            }
        };

        int[] leftLocation= {3,0};
        int[] rightLocation ={3,2};
        int[] touchLocation;
        int leftDist=0;
        int rightDists=0;



        for(int touch : numbers){
            if((touchLocation = leftNumber.get(touch))!=null){
                answer+="L";
                leftLocation[0] = touchLocation[0];
                leftLocation[1] = touchLocation[1];
            }
            else if ((touchLocation = rightNumber.get(touch))!=null){
                answer+="R";
                rightLocation[0] = touchLocation[0];
                rightLocation[1] = touchLocation[1];
            }
            else{
                touchLocation = centerNumber.get(touch);
                leftDist = abs(leftLocation[0] -touchLocation[0]) + abs(leftLocation[1] - touchLocation[1]);
                rightDists = abs(rightLocation[0] -touchLocation[0]) + abs(rightLocation[1] - touchLocation[1]);

                if(leftDist < rightDists || (leftDist==rightDists && hand.equals("left"))){
                    answer+="L";
                    leftLocation[0] = touchLocation[0];
                    leftLocation[1] = touchLocation[1];
                }
                else if(rightDists < leftDist || (leftDist == rightDists && hand.equals("right"))){
                    answer+="R";
                    rightLocation[0] = touchLocation[0];
                    rightLocation[1] = touchLocation[1];
                }

            }
        }

        return answer;
    }

}

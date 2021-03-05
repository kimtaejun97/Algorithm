package programmers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LagestNumber {
    public String solution(int[] number) {
        String answer = "";

        ArrayList<Integer> sameIndex = new ArrayList<>();
        for(int i=0; i<number.length; i++)
            sameIndex.add(i);

//        String[] numberList = new String[number.length];
        String[] numberList = new String[number.length];
        for (int i =0; i<number.length; i++) {
            numberList[i] = Integer.toString(number[i]);
        }

        while(sameIndex.size() !=0){
            int resultIndex =getLagestNumber(numberList,sameIndex, 0);
            answer+=numberList[resultIndex];
            numberList[resultIndex] ="";
            sameIndex.remove(Integer.valueOf(resultIndex));
        }


        return answer;
    }

    public int getLagestNumber(String[] nList,ArrayList<Integer> sIndex, int splitIndex){
        ArrayList<Integer> sameIndex = new ArrayList<>();


        for(int target =9; target>=0; target--){
            int maxLengthNumber =0;
            for(int i: sIndex){
                String numStr = nList[i];

                if (numStr.length() < splitIndex+1){
                    if ((numStr.substring(numStr.length()-1, numStr.length())).equals(Integer.toString(target))){
                        sameIndex.add(i);
                        maxLengthNumber ++;
                    }
                }
                else
                    if ((nList[i].substring(splitIndex, splitIndex+1)).equals(Integer.toString(target))){
                        sameIndex.add(i);
                    }
            }

            //중복된 수가 있는 경우 맨 앞의 수 리턴.
            if (sameIndex.size()!=0 && sameIndex.size() == maxLengthNumber){
                return sameIndex.get(0);
            }

            if (sameIndex.size() ==0 )
                continue;
            else if(sameIndex.size() ==1 )
                return sameIndex.get(0);
            else
                return getLagestNumber(nList,sameIndex, splitIndex+1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        LagestNumber ln = new LagestNumber();
        System.out.println(ln.solution(numbers));

        String[] test ={"978","31","9","971","97","9"};
        Arrays.sort(test, Collections.reverseOrder());
        for(String str : test)
            System.out.print(str+" ");
    }

}
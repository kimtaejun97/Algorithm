package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class LagestNumber2 {

    public String solution(int[] numbers){
        String answer="";

        String[] stringNumber =new String[numbers.length];
        for(int i=0; i< numbers.length; i++)
            stringNumber[i] = Integer.toString(numbers[i]);

        Arrays.sort(stringNumber);

        int start =0;
        int end = 0;
        String target =stringNumber[0].substring(0,1);
        ArrayList<String[]> spltNumber = new ArrayList<>();
        for(int i =1; i<stringNumber.length; i++){
            if(stringNumber[i].substring(0,1) != target){
                end = i-1;
                String[] splt = new String[end-start+1];
                int idx=0;
                for(int j =start; j<=end; j++,idx++){
                    splt[idx]=stringNumber[j];
                }
                spltNumber.add(splt);
                start = end+1;
                target = stringNumber[end+1];
            }
        }
        for(int i =0; i<spltNumber.size(); i++){
            String[] sortNumbers = lengthSort(spltNumber.get(i));
            for(int j =0; j<sortNumbers.length; j++)
                answer+=sortNumbers[j];
        }

        return answer;

    }

    public String[] lengthSort(String[] str) {
        String[] lengthsort = new String[str.length];

        int targetLength = str[str.length - 1].length();
        int start = str.length - 1;
        int end = str.length - 1;
        for (int i = str.length - 2; i >= 0; i--) {
            if (targetLength != str[i].length()) {
                end = i + 1;
                int idx = 0;
                for (int j = end; j <= start; j++, idx++)
                    lengthsort[idx] = str[j];

                start = end - 1;
                targetLength = str[start].length();
            }
            else if (i == 0) {
                end = 0;
                int idx = 0;
                for (int j = end; j <= start; j++, idx++)
                    lengthsort[idx] = str[j];
            }

        }
        return lengthsort;

    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        LagestNumber ln = new LagestNumber();
        System.out.println(ln.solution(numbers));

        int[] numbers2 = {6,10,2};
        int[] numbers3 ={40,403};
        System.out.println(ln.solution(numbers2));
        System.out.println(ln.solution(numbers3));
    }
}

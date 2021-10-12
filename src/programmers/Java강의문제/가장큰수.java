package programmers.Java강의문제;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {

        List<String> ns = new ArrayList<>();
        for(int num : numbers) ns.add(String.valueOf(num));

        ns.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        if(ns.get(0).equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String number : ns) sb.append(number);

        return sb.toString();
    }

    public static void main(String[] args) {
        가장큰수 test = new 가장큰수();;
        String solution = test.solution(new int[]{111111,1111211221,121111});
        System.out.println(solution);
    }



}

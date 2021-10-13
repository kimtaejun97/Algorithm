package programmers.광탈방지Java;

import java.util.*;
/*
정렬
 */
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
}

package programmers;

import java.util.*;

public class 캐시_2 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();

        if(cacheSize == 0){
            return cities.length * 5;
        }

        for(String c : cities){
            String city = c.toLowerCase();
            //hit
            if(cache.contains(city)){
                answer+=1;
                cache.remove(city);
                cache.add(city);
            }
            //miss
            else{
                answer+=5;
                if(cache.size() == cacheSize){
                    cache.remove(0);
                }
                cache.add(city);
            }

        }
        return answer;

    }
}

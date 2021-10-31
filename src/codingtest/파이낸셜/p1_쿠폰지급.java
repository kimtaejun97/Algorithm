package codingtest.파이낸셜;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p1_쿠폰지급 {
    public int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> coupon = new HashMap<>();
        for(String ids : id_list){
            List<String> dayCoupon = new ArrayList<>();
            String[] clients = ids.split(" ");
            for(String client: clients){
                if(dayCoupon.contains(client)) continue;
                coupon.put(client, coupon.getOrDefault(client, 0)+1);
                dayCoupon.add(client);
            }
        }

        for(int num : coupon.values()){
            if(num > k) answer+= k;
            else answer+= num;
        }

        return answer;
    }
}

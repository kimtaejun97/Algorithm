package programmers;

import java.util.LinkedHashMap;

public class 다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        final int PRICE = 100;
        int[] answer = new int[enroll.length];
        // <현재, 부모>
        LinkedHashMap<String, String> parent = new LinkedHashMap<>();
        //<사람, 수익>
        LinkedHashMap<String, Integer> profit =new LinkedHashMap<>();
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i],referral[i]);
            profit.put(enroll[i],0);
        }

        for(int i=0; i< seller.length; i++){
            int currentProfit = amount[i] * PRICE;
            String target = seller[i];
            while(target !="-"){
                if(currentProfit * 0.1 >=1)
                    profit.put(target, profit.get(target)+(int)Math.ceil(currentProfit *0.9));
                else {
                    profit.put(target, profit.get(target) + currentProfit);
                    break;
                }
                currentProfit = (int)(currentProfit *0.1);
                target = parent.get(target);
            }
        }
        int i =0;
        for(int v: profit.values()){
            answer[i] = v;
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        다단계칫솔판매 o = new 다단계칫솔판매();
        String[] e = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s = {"young", "john", "tod", "emily", "mary"};
        int[] a = {12,4,2,5,10};
        int[] ans =o.solution(e, r, s, a);

        for(int v :ans)
            System.out.println(v);
    }
    // 2 30 50 40


}

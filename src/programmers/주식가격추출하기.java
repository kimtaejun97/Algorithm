package codingtest;

import java.util.TreeMap;

public class p1 {
    public int[] solution(String code, String day, String[] data) {
        int[] answer;
        String[] spData;
        String targetCode;
        String targetPrice;
        String targetTime;
        TreeMap<String, String > pt = new TreeMap<>();

        for(String oneData: data){
            spData = oneData.split(" ");
            targetCode = spData[1].split("=")[1];
            targetPrice = spData[0].split("=")[1];
            targetTime = spData[2].split("=")[1];


            if(targetCode.equals(code) && targetTime.substring(0,8).equals(day)){
                pt.put(targetTime, targetPrice);
            }
        }

        answer = new int[pt.size()];
        int count=0;
        for(String pric :pt.values()){
            answer[count++] = Integer.parseInt(pric);
        }

        return answer;
    }

    public static void main(String[] args) {
        p1 p = new p1();
        String code = "012345";
        String day = "20190620";
        String[] data = {"price=80 code=987654 time=2019062113","price=90 code=012345 time=2019062014","price=120 code=987654 time=2019062010","price=110 code=012345 time=2019062009","price=95 code=012345 time=2019062111"};

        int[] answer = p.solution(code, day, data);
        for(int v :answer)
            System.out.println(v);

    }

}


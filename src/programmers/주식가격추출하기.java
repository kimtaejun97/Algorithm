package programmers;

import java.util.TreeMap;

public class 주식가격추출하기 {
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


}


package programmers;

import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class k_주차요금 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, String> in = new HashMap<>();
        Map<String, Integer> time = new HashMap<>();
        Map<String, Integer> prices = new HashMap<>();

        // 하루 주차 시간 계산.
        for(String r : records){
            String[] record = r.split(" ");
            String plateNumber = record[1];

            if(record[2].equals("IN")){
                in.put(plateNumber, record[0]);
            }
            //OUT
            else{
                String inDate = in.get(plateNumber);
                int parkingTime = getParkingTime(inDate, record[0]);

                time.put(plateNumber, time.getOrDefault(plateNumber, 0)+parkingTime);
                in.remove(plateNumber);
            }
        }
        // 입차 후 출차 기록이 없는 경우.
        for(String plateNumber : in.keySet()){
            int parkingTime = getParkingTime(in.get(plateNumber), "23:59");
            time.put(plateNumber, time.getOrDefault(plateNumber, 0) + parkingTime);
        }

        // 주차 요금 계산
        for(String plateNumber: time.keySet()){
            int parkingTime = time.get(plateNumber);
            int basicTime = fees[0];
            int perTime =fees[2];

            // 기본 요금
            if(parkingTime <= basicTime){
                prices.put(plateNumber, fees[1]);
            }
            else{
                int over = parkingTime - basicTime;
                int perCount = (over / fees[2]);
                if(over % perTime != 0){
                    perCount++;
                }
                int price = fees[1] + perCount * fees[3];
                prices.put(plateNumber, price);
            }
        }

        List<Map.Entry<String, Integer>> sorted = prices.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        answer = new int[sorted.size()];

        for(int i=0; i< sorted.size(); i++){
            answer[i] = sorted.get(i).getValue();
        }

        return answer;
    }

    private int getParkingTime(String inDate, String outDate) {
        String[] in = inDate.split(":");
        String[] out = outDate.split(":");

        int inToMinute = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
        int outToMinute = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);

        return outToMinute - inToMinute;
    }

    public static void main(String[] args) {
        k_주차요금 test = new k_주차요금();
        int[] solution = test.solution(new int[]{181, 5000, 11, 600}, new String[]{"00:00 5961 IN","03:35 5961 OUT"});

        System.out.println(Arrays.toString(solution));
    }
}

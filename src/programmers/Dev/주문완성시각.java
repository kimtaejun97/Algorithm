package programmers.Dev;

import java.util.*;

/*
마지막 주문 음식의 완성될 시각 계산
큐 방식으로 처리.
 */
public class 주문완성시각 {
    public int solution(int n, String[] recipes, String[] orders) {
        int answer = 0;
        Map<String, Integer> recipesMap = new HashMap<>();
        OrderQueue orderQueue = new OrderQueue(n);

        for(String r : recipes){
            String[] split = r.split(" ");
            recipesMap.put(split[0], Integer.parseInt(split[1]));
        }

        for(int i=0; i<orders.length; i++){
            String[] split = orders[i].split(" ");
            Order order = new Order(Integer.parseInt(split[1]), recipesMap.get(split[0]));

            if(i == orders.length -1){
                answer =  orderQueue.acceptOrder(order);
                break;
            }
            orderQueue.acceptOrder(order);
        }

        return answer;
    }
}

class Order{
    int orderTime;
    int cookingTime;

    public Order(int orderTime, int cookingTime) {
        this.orderTime = orderTime;
        this.cookingTime = cookingTime;
    }
}

class OrderQueue{
    PriorityQueue<Integer> q = new PriorityQueue();
    int maxSize;

    public OrderQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    // endTime 반환.
    public int acceptOrder(Order order){
        int currEndTime;

        if(isFull()){
            int prevEndTime = q.poll();
            if(prevEndTime >= order.orderTime){
                currEndTime = prevEndTime + order.cookingTime;
            }else{
                currEndTime = order.orderTime + order.cookingTime;
            }
        }
        else{
            currEndTime = order.orderTime + order.cookingTime;
        }

        q.add(currEndTime);
        return currEndTime;
    }

    private boolean isFull(){
        return q.size() == maxSize? true:false;
    }
}
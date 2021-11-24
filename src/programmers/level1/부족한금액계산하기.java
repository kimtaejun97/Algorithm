package programmers.level1;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        for(int i=1; i<=count; i++){
            totalPrice += i*price;
        }
        return Math.max(totalPrice - money , 0);
//        return Math.max((long)price * (count*(count+1)/2) - money, 0);
    }
}

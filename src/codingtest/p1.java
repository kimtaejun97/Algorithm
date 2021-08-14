package codingtest;

public class p1 {
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료

        // 부가 가치세 : 과세금액의 10% 소수점 첫째 올림. vat
        // 과세 금액 : 공급가액 - 비과세 taxAmount
        // 공급 대가 :  공급 가액 + 부가가치세 == 주문금액 - 봉사료
        // 주문금액 - 봉사료 == 과세 + 비과세 +부가가치세
        // 과세 + 과세* 0.1 = 주문금액 - 봉사료 - 비과세



        long answer = 0;

        if(orderAmount - serviceFee -taxFreeAmount <=1)
            return 0;



        long vat = 0;







        return answer;


    }
}

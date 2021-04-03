package codingtest;

import java.util.ArrayList;

public  class p3 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer= new int[enroll.length];
        String refer = "";
        String presen = "";
        int presPr = 0;
        ArrayList<String> enrollLS = new ArrayList<>();

        for(String er :enroll)
            enrollLS.add(er);

        for(int i =0; i<seller.length; i++){
            presen = seller[i];
            presPr = amount[i] *100;

            while(true){
                refer = referral[enrollLS.indexOf(presen)];
                if(refer !="-"){
                    if(presPr >1)
                        answer[enrollLS.indexOf(presen)] += (int)(presPr*0.9);
                    else {
                        answer[enrollLS.indexOf(presen)] += presPr;
                        break;
                    }
                    presen = refer;
                    presPr = (int)(presPr*0.1);
                }
                else
                    break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        String[] e = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s = {"sam", "emily", "jaimie", "edward"};
        int[] a = {2,3,5,4};
        int[] ans =solution(e, r, s, a);

        for(int v :ans)
            System.out.println(v);
    }
}

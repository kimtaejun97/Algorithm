package programmers;

public class p2 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int placeNum = 0;
        boolean rPartition =false;
        boolean bPartition =false;
        char buff;

        for(int i =0; i<places.length; i++)
            answer[i] =-1;

        char sub;
        for(String[] place : places){

            for(int i=0; i<place.length; i++){

                for(int j=0; j<place[i].length(); j++){
                   sub = place[i].charAt(j);

                   if(sub == 'P'){
                       // 열
                       if(j+1 < 5){
                           buff =place[i].charAt(j+1);
                           if(buff =='P') {
                               answer[placeNum] = 0;
                               break;
                           }
                           else if(buff =='X') rPartition=true;
                       }

                       if(j+2 <5 && place[i].charAt(j+2) =='P') {
                           if(!rPartition) {
                               answer[placeNum] = 0;
                               break;
                           }
                       }

                       //행
                       if(i+1<5){
                           buff =place[i+1].charAt(j);
                           if(buff=='P') {
                               answer[placeNum] = 0;
                               break;
                           }
                           else if(buff =='X') bPartition=true;

                       }
                       if(i+2<5){
                           if(place[i+2].charAt(j) =='P') {
                               if(!bPartition) {
                                   answer[placeNum] = 0;
                                   break;
                               }
                           }
                       }

                       //대각선
                       if(j+1 <5 && i+1<5){
                           if(place[i+1].charAt(j+1) =='P'){
                               if(!rPartition || !bPartition){
                                   answer[placeNum] = 0;
                                   break;
                               }

                           }

                       }
                       if(j-1>=0 && i+1<5){
                         if(place[i+1].charAt(j-1)=='P'){
                             if(!bPartition || place[i].charAt(j-1) !='X'){
                                 answer[placeNum] =0;
                                 break;
                             }
                         }
                       }
                   }
                }
                rPartition =false;
                bPartition = false;
                if(answer[placeNum] !=-1){
                    break;
                }
            }
            if(answer[placeNum] ==-1)
                answer[placeNum] =1;
            placeNum++;
        }

        return answer;
    }
}
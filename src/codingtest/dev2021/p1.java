package codingtest.dev2021;


import java.util.ArrayList;
import java.util.List;

public class p1 {
    public String solution(String[] registered_list, String new_id) {

        int N = 0;
        String S = new_id;
        for(int i =0; i<new_id.length(); i++){
            char[] characters = new_id.toCharArray();
            char character =  characters[i];
            if(character >='0' && character<='9'){
                S = new_id.substring(0,i);
                N = Integer.parseInt(new_id.substring(i));
                break;
            }
        }
        List<String> SIds = new ArrayList<>();
        for(String r : registered_list){
            if(r.contains(S)) SIds.add(r);
        }
        while (true) {
            if(!SIds.contains(new_id)){
                return new_id;
            }
            N ++;
            new_id = S + N;
        }
    }
}

